package com.dimtechApp.dimtechApp.controllers;

import com.dimtechApp.dimtechApp.models.Convidado;
import com.dimtechApp.dimtechApp.models.Evento;
import com.dimtechApp.dimtechApp.repository.ConvidadoRepository;
import com.dimtechApp.dimtechApp.repository.EventoRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author douglas borges egidio.
 * @DouglasInfo07.
 * @since 25/08/2019.
 */
@Controller
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private ConvidadoRepository convidadoRepository;

    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
    public String formulario() {
        return "formularioEvento";
    }

    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
    public String formulario(@Valid Evento evento, BindingResult result, RedirectAttributes atrAttributes) {

        if (result.hasErrors()) {
            atrAttributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/cadastrarEvento";
        } else {
            eventoRepository.save(evento);
            atrAttributes.addFlashAttribute("mensagem", "Evento cadastrado com sucesso!!");
            return "redirect:/cadastrarEvento";
        }
    }

    @RequestMapping("/eventos")
    public ModelAndView listaEventos() {
        ModelAndView modelAndView = new ModelAndView("index");
        Iterable<Evento> eventos = eventoRepository.findAll();//Busca todos os evento no banco de dados
        modelAndView.addObject("eventos", eventos);
        return modelAndView;
    }

    @RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
    public ModelAndView detalhesEventoGet(@PathVariable("codigo") long codigo) {
        Evento evento = eventoRepository.findByCodigo(codigo);
        ModelAndView modelAndView = new ModelAndView("detalhesEvento");
        modelAndView.addObject("evento", evento);
        Iterable<Convidado> convidados = convidadoRepository.findByEvento(evento);
        modelAndView.addObject("convidados", convidados);
        return modelAndView;
    }

    @RequestMapping(value = "/{codigo}", method = RequestMethod.POST)
    public String detalhesEventoPost(
            @PathVariable("codigo") long codigo,
            @Valid Convidado convidado,
            BindingResult result,
            RedirectAttributes attributes
    ) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/{codigo}";
        } else {
            Evento evento = eventoRepository.findByCodigo(codigo);
            convidado.setEvento(evento);
            convidadoRepository.save(convidado);
            attributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso!!");
            return "redirect:/{codigo}";
        }
    }
    
    @RequestMapping("/deletarEvento")
    public String deletarEvento(long codigo) {
        Evento evento = eventoRepository.findByCodigo(codigo);
        eventoRepository.delete(evento);
        return "redirect:/eventos";
    }
    
    @RequestMapping("/deletarConvidado")
    public String deletarConvidado(String Rg) {
        Convidado convidado = convidadoRepository.findByRg(Rg);
        convidadoRepository.delete(convidado);
        Evento evento = convidado.getEvento();
        long codLong = evento.getCodigo();
        String codigo = "" + codLong;
        return "redirect:/" + codigo;
    }

}
