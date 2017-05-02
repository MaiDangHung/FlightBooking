
package controller;

import entity.AirCraftEntity;
import entity.AirportStationEntity;
import entity.FlightEntity;
import entity.LuggageEntity;
import entity.RouteEntity;
import entity.SearchEntity;
import entity.TicketEntity;
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
import repository.AirportStationRepository;
import repository.FlightRepository;
import repository.LuggageRepository;
import repository.RouteRepository;
import repository.SearchRepository;
import repository.TicketRepository;

@Controller
@RequestMapping(value="/")
public class TicketController {
    @Autowired
    RouteRepository routeRepo;
    @Autowired
    SearchRepository searchRepo;
    @Autowired
    AirCraftRepository airCraftRepo;
    @Autowired
    FlightRepository flightRepo;
    @Autowired
    TicketRepository ticketRepo;
    @Autowired
    LuggageRepository luggageRepo;
    @Autowired
    AirportStationRepository airportStationRepo;
    @RequestMapping(method=GET)
    public String showBooks(Model model){
        List<RouteEntity> routeList=(List<RouteEntity>)routeRepo.findAll();
        for(int i=0;i<routeList.size();i++){
            for(int j=i+1;j<routeList.size();j++){
                if(routeList.get(i).getFromsStation().equals(routeList.get(j).getFromsStation())){
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
        String fromsGo=froms;
        String toGo=tos;
        String hidden="hidden";
        String message="";
        String result="";
        String message1="";
        String result1="";
        String table1="";
        String flight1="flight2";
        String flight2="flight1";
        String fromName=airportStationRepo.getAirName(froms);
        String toName=airportStationRepo.getAirName(tos);
        if(hinhthuc.equals("motchieu")){
            resultList=searchRepo.getAllByDate1(date,froms,tos);
            if(resultList.size()>0){
                fromName=airportStationRepo.getAirName(resultList.get(0).getFroms());
                model.addAttribute("fromName", fromName);
                toName=airportStationRepo.getAirName(resultList.get(0).getTos());
                model.addAttribute("toName", toName);
                model.addAttribute("bookList", resultList);
                message="Chuyến bay từ '"+froms+"' đến '"+tos+"' vào ngày '"+date+"'<br> <hr> ";
                model.addAttribute("message",message);
                model.addAttribute("hidden",hidden);
            }
            else{
                message="Không có chuyến bay từ "+fromName+ " đến "+toName+" vào ngày "+date+"'<br> <hr> ";
                resultList = searchRepo.getAllOneWay(date,froms, tos);
                if(resultList.size()==0){
                    table1="hidden";
                    model.addAttribute("table1", table1);
                }else{
                result="Một số chuyến bay từ "+fromName+" đến "+toName+" sau ngày '"+date+"'";
                
                hidden="hidden" ;
                model.addAttribute("date", date);
                model.addAttribute("fromGo", froms);
                model.addAttribute("toGo", tos);
                model.addAttribute("bookList", resultList);
                model.addAttribute("hidden",hidden);
                model.addAttribute("message",message);
                model.addAttribute("result",result);
                fromName=airportStationRepo.getAirName(resultList.get(0).getFroms());
                model.addAttribute("fromName", fromName);
                toName=airportStationRepo.getAirName(resultList.get(0).getTos());
                model.addAttribute("toName", toName);
                }
            }
        }else
        {
            if(hinhthuc.equals("khuhoi")){
                resultList=searchRepo.getAllByDate1(date,froms,tos);
                if(resultList.size()>0){
                    fromName=airportStationRepo.getAirName(resultList.get(0).getFroms());
                    model.addAttribute("fromName", fromName);
                    toName=airportStationRepo.getAirName(resultList.get(0).getTos());
                    model.addAttribute("toName", toName);
                    model.addAttribute("bookList", resultList);
                    message="Chuyến bay từ "+fromName+" đến "+tos+" vào ngày '"+date+"'<br> <hr> ";
                    model.addAttribute("message",message);
                    model.addAttribute("hidden",hidden);

                }
                else{
                    message="Không có chuyến bay từ "+fromName+" đến "+toName+" vào ngày '"+date+"'<br> <hr> ";
                    resultList = searchRepo.getAllOneWay(date,froms, tos);
                    if(resultList.size()==0){
                        table1="hidden";
                        model.addAttribute("table1", table1);
                    }else{
                    result="Một số chuyến bay từ "+fromName+" đến "+toName+" sau ngày '"+date+"'";

                    hidden="hidden" ;
                    model.addAttribute("date", date);
                    model.addAttribute("fromGo", froms);
                    model.addAttribute("toGo", tos);
                    model.addAttribute("bookList", resultList);
                    model.addAttribute("hidden",hidden);
                    model.addAttribute("message",message);
                    model.addAttribute("result",result);
                    fromName=airportStationRepo.getAirName(resultList.get(0).getFroms());
                    model.addAttribute("fromName", fromName);
                    toName=airportStationRepo.getAirName(resultList.get(0).getTos());
                    model.addAttribute("toName", toName);
                    }
                }
                resultList1=searchRepo.getAllByDate1(date2,tos,froms);
                if(resultList1.size()>0){
                    model.addAttribute("bookList1", resultList1);
                    message1="Chuyến bay từ "+toName+" đến "+fromName+" vào ngày '"+date2+"'<br> <hr> ";
                    model.addAttribute("message1",message1);
                    hidden="visible" ;
                    model.addAttribute("hidden",hidden);
                    fromName=airportStationRepo.getAirName(resultList1.get(0).getFroms());
                    model.addAttribute("fromName", fromName);
                    toName=airportStationRepo.getAirName(resultList1.get(0).getTos());
                    model.addAttribute("toName", toName);
                }
                else{
                    message1="Không có chuyến bay từ "+toName+" đến "+fromName+" vào ngày '"+date2+"'<br> <hr> ";
                    resultList1 = searchRepo.getAllOneWay(date2,tos, froms);
                    if(resultList1.size()==0){
                        hidden="hidden";
                        model.addAttribute("hidden", hidden);
                    }else{
                        result1="Một số chuyến bay từ "+toName+" đến "+fromName+" sau ngày '"+date2+"'";
                        hidden="visible" ;
                        model.addAttribute("date", date);
                        model.addAttribute("fromGo", froms);
                        model.addAttribute("toGo", tos);
                        model.addAttribute("bookList1", resultList1);
                        model.addAttribute("hidden",hidden);
                        model.addAttribute("message1",message1);
                        model.addAttribute("result1",result1);
                        fromName=airportStationRepo.getAirName(resultList1.get(0).getFroms());
                    model.addAttribute("fromName", fromName);
                    toName=airportStationRepo.getAirName(resultList1.get(0).getTos());
                    model.addAttribute("toName", toName);
                    }
                }
//                resultList1 = searchRepo.getAllOneWay(date2,tos, froms);
//                hidden="visible" ;
//                model.addAttribute("date", date);
//                model.addAttribute("fromGo", froms);
//                model.addAttribute("toGo", tos);
//                model.addAttribute("bookList1", resultList1);
//                model.addAttribute("hidden",hidden);
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
            response+= "<option value='" + des.getTosStation().getAirportID() +"'>"
                    +des.getTosStation().getAirportName() +"</option> ";
        
        }        
        response+= " </select>";  
        System.out.println(response);
         
        if(routeList.size() > 0){
            return response;
                    
        }
        else
            return "There is no destination";

    }
    
//    @RequestMapping(value="/showFlight/{flightID}", method = GET)
//    public String showDetailFlight(@PathVariable("flightID") int flightID,Model model){
//        
//        AirCraftEntity airCarft=airCraftRepo.getAirByFlightID(flightID);
//        int numberSeatOfEco=airCarft.getEcoNumberSeats();
//        model.addAttribute("numberSeatOfEco",numberSeatOfEco);
//        RouteEntity route=routeRepo.getRouteByID(flightID);
//        model.addAttribute("route",route);
//        FlightEntity flight=flightRepo.findOne(flightID);
//        model.addAttribute("flight", flight);
//        return "chooseNumberSeat";
//    }
    
    @RequestMapping(value="/showFlight", method = GET)
    public String showDetailFlight(@RequestParam("flight") int flightID,@RequestParam(value="flight1",required = false, defaultValue = "0") int flightID1,Model model){
        String hidden="hidden";
        List<TicketEntity> ticketList;
        List<TicketEntity> ticketList1;
        List<LuggageEntity> luggage;
        luggage=(List<LuggageEntity>)luggageRepo.findAll();
        if(flightID1 == 0){
                RouteEntity route=routeRepo.getRouteByID(flightID);
                model.addAttribute("route",route);
                FlightEntity flight=flightRepo.findOne(flightID);
                model.addAttribute("flight", flight);
                model.addAttribute("hidden",hidden);
                model.addAttribute("flightID1", flightID);
                model.addAttribute("flightID2",flightID1);
                ticketList=ticketRepo.getNumberSeatByFlightID(flightID);
                model.addAttribute("seatNumber", ticketList);
                model.addAttribute("luggage",luggage);
        }
        else{
                hidden="visible";
                RouteEntity route=routeRepo.getRouteByID(flightID);
                model.addAttribute("route",route);
                FlightEntity flight=flightRepo.findOne(flightID);
                model.addAttribute("flight", flight);
                model.addAttribute("hidden",hidden);
                ticketList=ticketRepo.getNumberSeatByFlightID(flightID);
                ticketList1=ticketRepo.getNumberSeatByFlightID(flightID1);
                model.addAttribute("seatNumber", ticketList);
                model.addAttribute("seatNumber1", ticketList1);
                RouteEntity route1=routeRepo.getRouteByID(flightID1);
                model.addAttribute("route1",route1);
                FlightEntity flight1=flightRepo.findOne(flightID1);
                model.addAttribute("flight1", flight1);
                model.addAttribute("flightID1", flightID);
                model.addAttribute("flightID2",flightID1);
                model.addAttribute("luggage",luggage);
        }
        
        return "chooseNumberSeat";
    }
}
