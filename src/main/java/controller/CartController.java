
package controller;

import component.CartComponent;
import entity.AirCraftEntity;
import entity.BookingEntity;
import entity.CartEntity;
import entity.ClassTicketEntity;
import entity.CreditCardEntity;
import entity.FlightEntity;
import entity.LuggageEntity;
import entity.RouteEntity;
import entity.TicketEntity;
import entity.TypeTicketEntity;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.AirCraftRepository;
import repository.BookingRepository;
import repository.ClassTicketRepository;
import repository.CreditCardRepository;
import repository.FlightRepository;
import repository.LuggageRepository;
import repository.RouteRepository;
import repository.SearchRepository;
import repository.TicketRepository;
import repository.TypeTicketRepository;

@Controller
@Scope("session")
public class CartController {
    @Autowired
    RouteRepository routeRepo;
    @Autowired
    SearchRepository searchRepo;
    @Autowired
    AirCraftRepository airCraftRepo;
    @Autowired
    FlightRepository flightRepo;
    @Autowired
    CartComponent cartComponent;
    @Autowired
    ClassTicketRepository classTicketRepo;
    @Autowired
    TypeTicketRepository typeTicketRepo;
    @Autowired
    BookingRepository bookingRepo;
    @Autowired
    TicketRepository ticketRepo;
    @Autowired
    CreditCardRepository creditCardRepo;
    @Autowired
    LuggageRepository luggagerepo;
        
    
    @RequestMapping(value = "/addToCart", method = GET)
    public String addToCart(@RequestParam("flightID1") int flightID1,@RequestParam("flightID2") int flightID2,@RequestParam("flightID") int flightID,@RequestParam("seat2") String seat,@RequestParam("classTicket") int classTicketID,@RequestParam("typeTicket") int typeTicketID,@RequestParam("cusName") String cusName,@RequestParam("cmnd") String cmnd,@RequestParam("luggage") String luggage, Model model) {
        AirCraftEntity airCarft=airCraftRepo.getAirByFlightID(flightID);
        RouteEntity route=routeRepo.getRouteByID(flightID);
        ClassTicketEntity classTicket=classTicketRepo.findOne(classTicketID);
        FlightEntity flight=flightRepo.findOne(flightID);
        TypeTicketEntity typeTicket=typeTicketRepo.findOne(typeTicketID);
        LuggageEntity luggageEntity=luggagerepo.getLuggageByName(luggage);
        if(typeTicketID==2)
            cmnd="";
        cartComponent.addComponent(new CartEntity(flightID, route.getFromsStation().getAirportName(),route.getTosStation().getAirportName(),flight.getDateGoes(),flight.getTimeGoes(),seat,flight.getPrice()-flight.getPrice()*(100-typeTicket.getPercents())/100+flight.getPrice()*classTicket.getPercents()/10+luggageEntity.getPrice(),classTicket.getClassTicketName(),typeTicket.getTypeName(),cusName,cmnd,luggage));
        //model.addAttribute("cartComponent", cartComponent);
        int totalCart=cartComponent.getCount();
        model.addAttribute("totalCart",totalCart);
        model.addAttribute("cartComponent", cartComponent);
        model.addAttribute("color","green");
        model.addAttribute("luggagePrice", luggageEntity.getPrice());
        if(flightID2==0)
            return "redirect:/showFlight?flight="+flightID1;
        else
            return "redirect:/showFlight?flight="+flightID1+"&flight1="+flightID2;
    }
    @RequestMapping(value="/del/{seat}",method = GET)
    public String removeCart(@PathVariable("seat")String seat,Model model){
        cartComponent.removeComponent(seat);
        BookingEntity booking = new BookingEntity();
        model.addAttribute("cartComponent", cartComponent);
        model.addAttribute("booking", booking);
        double totalPriceinCart=0;
        for(CartEntity cart: cartComponent.getCart()){
            totalPriceinCart+=cart.getPrice();
        }
        model.addAttribute("total",totalPriceinCart+20*totalPriceinCart/100);
        return "checkOut";
    }
    @RequestMapping(value = "/checkOut", method = GET)
    public String checkOut(Model model) {
        //model.addAttribute("cartComponent", cartComponent);
        BookingEntity booking = new BookingEntity();
        model.addAttribute("cartComponent", cartComponent);
        model.addAttribute("booking", booking);
        double totalPriceinCart=0;
        for(CartEntity cart: cartComponent.getCart()){
            totalPriceinCart+=cart.getPrice();
        }
        model.addAttribute("total",totalPriceinCart+20*totalPriceinCart/100);
        return "checkOut";
    }
    @RequestMapping(value = "/checkOutFinish", method = POST)
    public String checkOutFinish(@RequestParam("cardNumber") int cardNumber,@RequestParam("validateNumber") int validateNumber,@RequestParam("securityNumber") int securityNumber,BookingEntity booking,Model model) {
        CreditCardEntity creditCard=creditCardRepo.getCreditCardByCardNumber(cardNumber);
        String cardNumber1="";
        String validateNumber1="";
        String securiryNumber1="";
        String amount="";
        double totalPriceinCart=0;
        for(CartEntity cart: cartComponent.getCart()){
            totalPriceinCart+=cart.getPrice();
        }
        if(creditCard == null){
            cardNumber1="Không có card này !!!";
            model.addAttribute("cardNumber1", cardNumber1);
        }
        else
        {
            if(creditCard.getValidateNumber() != validateNumber){
                validateNumber1="Mã xác nhận không đúng !!!";
                model.addAttribute("validateNumber1", validateNumber1);
            }
            else
            {
                if(creditCard.getSecurityNumber()!=securityNumber){
                    securiryNumber1="Mã bảo vệ không đúng !!!";
                    model.addAttribute("securityNumber1", securiryNumber1);
                    }
                else
                {
                    if(creditCard.getAmount() < totalPriceinCart){
                        amount="Số tiền trong tài khoản không đủ !!!";
                        model.addAttribute("amount", amount);
                        }
                    else{
                        booking.setDateBook(new Date());
                        booking.setTotalAmount(0);
                        bookingRepo.save(booking);
                //        List<BookingEntity> listBooking=(List<BookingEntity>)bookingRepo.findAll();
                //        int booking1=listBooking.get(listBooking.size()-1).getBookingID();
                        for(CartEntity cart: cartComponent.getCart()){
                //            orderDetail.setOrder(orders);
                //            orderDetailList.add(orderDetail);
                            ClassTicketEntity classTicketEntity=classTicketRepo.getClassTicketByName(cart.getClassTicket());
                            LuggageEntity luggageEntity=luggagerepo.getLuggageByName(cart.getLuggage());
                            FlightEntity flightEntity=new FlightEntity();
                            flightEntity.setFlightID(cart.getFlightID());
                            TypeTicketEntity typeTicket=typeTicketRepo.getTypeTicketByName(cart.getTypeTicket());
                //            TypeTicketEntity typeTicket=new TypeTicketEntity();
                //            typeTicket.setTypeID(1);
                //            TicketEntity ticket=new TicketEntity(cart.getSeat(), cart.getCusName(), cart.getCmnd(), cart.getPrice()+cart.getPrice()*20/100, booking, classTicketEntity, luggageEntity, flightEntity, typeTicket);
                            TicketEntity ticket=new TicketEntity(cart.getSeat(), cart.getCusName(), cart.getCmnd(), cart.getPrice()+cart.getPrice()*20/100+luggageEntity.getPrice(), booking.getBookingID(),typeTicket.getTypeID(),  flightEntity.getFlightID(),classTicketEntity.getClassTicketID(), luggageEntity.getLugID());
                            ticketRepo.save(ticket);
                            }

                            cartComponent.setComponent(null);
                            return "paymentSuccess";
                            }
                    }
                }
            }
        return "redirect:/showFlight/checkOut";
    }
    @RequestMapping(value="/cardNumber/{from}",produces="application/text;charset=utf8",method=GET)
    public @ResponseBody String showAJAXihh(@PathVariable("from") int from) throws UnsupportedEncodingException{
        CreditCardEntity creditCard=creditCardRepo.getCreditCardByCardNumber(from);
        String response="";
        //Build Response
         System.out.println(response);
//         model.addAttribute("message", from);
            if(creditCard != null){
                return response;
                        
            }
            else
                return "Không có card này";

    }
    @RequestMapping(value="/validateNumber/{from}/{validate}",produces="application/text;charset=utf8",method=GET)
    public @ResponseBody String showAJAXihh1(@PathVariable("from") int from,@PathVariable("validate") int validate) throws UnsupportedEncodingException{
        CreditCardEntity creditCard=creditCardRepo.getCreditCardByValidateNumber(from, validate);
        String response="";
        //Build Response
         System.out.println(response);
//         model.addAttribute("message", from);
            if(creditCard != null){
                return response;
                        
            }
            else
                return "Mã xác nhận này không đúng !!!";

    }
    @RequestMapping(value="/securityNumber/{from}/{security}",produces="application/text;charset=utf8",method=GET)
    public @ResponseBody String showAJAXihh2(@PathVariable("from") int from,@PathVariable("security") int security) throws UnsupportedEncodingException{
        CreditCardEntity creditCard=creditCardRepo.getCreditCardByValidateNumber(from, security);
        String response="";
        //Build Response
         System.out.println(response);
//         model.addAttribute("message", from);
            if(creditCard != null){
                return response;
                        
            }
            else
                return "Mã xác nhận này không đúng !!!";

    }
}
