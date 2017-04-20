
package controller;

import entity.AirCraftEntity;
import entity.RouteEntity;
import entity.SearchEntity;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.AirCraftRepository;
import repository.RouteRepository;
import repository.SearchRepository;

@Controller
@RequestMapping(value="/")
public class TicketController {
    @Autowired
    RouteRepository routeRepo;
    @Autowired
    SearchRepository searchRepo;
    @Autowired
    AirCraftRepository airCraftRepo;
    
    
    @RequestMapping(method=GET)
    public String showBooks(Model model){
        List<RouteEntity> routeList=(List<RouteEntity>)routeRepo.findAll();
        for(int i=0;i<routeList.size();i++){
            for(int j=i+1;j<routeList.size();j++){
                if(routeList.get(i).getFroms().equals(routeList.get(j).getFroms())){
                    routeList.remove(j);
                }
            }
        }
        model.addAttribute("routeList", routeList);
        return "index";
    }
    @RequestMapping(value = "/search", method = GET)
    public String search(@RequestParam("froms")String froms,@RequestParam("date2")String date2,@RequestParam("date1")String date,@RequestParam("group1")String hinhthuc,@RequestParam("tos")String tos, Model model){
        List<SearchEntity> resultList;
        List<SearchEntity> resultList1;
        String message="";
        String message1="";
        String hidden="false";
        if(hinhthuc.equals("motchieu")){
            resultList = searchRepo.getAllOneWay(date,froms, tos);
            hidden="hidden" ;
            message=tos;
            message1=froms;
            model.addAttribute("message", date);
            model.addAttribute("message1", message1);
            model.addAttribute("bookList", resultList);
            model.addAttribute("hidden",hidden);
        }else
        {
            if(hinhthuc.equals("khuhoi")){
            resultList = searchRepo.getAllOneWay(date,froms, tos);
            message=tos;
            message1=froms;
            model.addAttribute("message", date);
            model.addAttribute("message1", message1);
            model.addAttribute("bookList", resultList);  
                
            resultList1 = searchRepo.getAllOneWay(date2,tos, froms);
            hidden="visible" ;
            message=tos;
            message1=froms;
            model.addAttribute("message", date);
            model.addAttribute("message1", message1);
            model.addAttribute("bookList1", resultList1);
            model.addAttribute("hidden",hidden);
        }
        }
        return "book";
    }
    @RequestMapping(value="/ajaxDemo/{from}",produces="application/text;charset=utf8")
    public @ResponseBody String showAJAX(@PathVariable("from") String from) throws UnsupportedEncodingException{
        List<RouteEntity> routeList=(List<RouteEntity>) routeRepo.getRouteByFroms(from);
        String response="";
        //Build Response
        response= "<select id='destination' name='tos' required> ";
        for(RouteEntity des: routeList){
            response+= "<option value='" + des.getTos() +"'>"
                    +des.getTos() +"</option> ";
        
        }        
        response+= " </select>";  
        System.out.println(response);
         
        if(routeList.size() > 0){
            return response;
                    
        }
        else
            return "There is no destination";

    }
    @RequestMapping(value="/showFlight/{flightID}", method = GET)
    public String showDetailFlight(@PathVariable("flightID") int flightID,Model model){
        
        AirCraftEntity airCarft=airCraftRepo.getAirByFlightID(flightID);
        int numberSeatOfEco=airCarft.getEcoNumberSeats();
        int numberSeatOfSky=airCarft.getSkybossNumberSeats();
        model.addAttribute("numberSeatOfEco",numberSeatOfEco);
        model.addAttribute("count",numberSeatOfEco);
        return "chooseNumberSeat";
    }
}
