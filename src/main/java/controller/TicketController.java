
package controller;

import entity.RouteEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.RouteRepository;

@Controller
@RequestMapping(value="/")
public class TicketController {
    @Autowired
    RouteRepository routeRepo;
    
    
    @RequestMapping(method=GET)
    public String showBooks(Model model){
        List<RouteEntity> routeList=(List<RouteEntity>)routeRepo.findAll();
        model.addAttribute("routeList", routeList);
        return "index";
    }
    
    @RequestMapping(value="/{cID}",method = GET)
    public String delete(@PathVariable("cID") String id, Model model){
        List<RouteEntity> routeList1=(List<RouteEntity>)routeRepo.getRouteByFroms(id);
        String action="search";
        //model.addAttribute("action", action);
        model.addAttribute("routeList1", routeList1);
        return "redirect:/";
    } 
    @RequestMapping(value="/search", method = POST)
    public String update(){
        return "redirect:/";
    }
}
