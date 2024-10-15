package hr.ticketmaster.finder.ai.ticketmasterfinderai.controller.rest;

import hr.ticketmaster.finder.ai.ticketmasterfinderai.dto.TicketDTO;
import hr.ticketmaster.finder.ai.ticketmasterfinderai.model.Ticket;
import hr.ticketmaster.finder.ai.ticketmasterfinderai.model.TicketTypeEnum;
import hr.ticketmaster.finder.ai.ticketmasterfinderai.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("rest")
@AllArgsConstructor
public class TicketsRestController {

    private TicketService ticketService;


    @GetMapping("/tickets")
    public List<TicketDTO> getTicketList() {
        return ticketService.findAll();
    }

    @GetMapping("/ticket/{id}")
    public TicketDTO getTicketById(@PathVariable Integer id) {
        return ticketService.findById(id).get();
    }

    @PostMapping("/ticket")
    public void createNewTicket(@RequestBody TicketDTO ticketDTO) {
        ticketService.save(ticketDTO);
    }

}
