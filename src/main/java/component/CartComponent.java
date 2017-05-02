
package component;

import entity.CartEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class CartComponent {
    List<CartEntity> cart;
    
    public CartComponent(){
        cart = new ArrayList<CartEntity>();
    }

    public List<CartEntity> getCart() {
        return cart;
    }

    public void setCart(List<CartEntity> cart) {
        this.cart = cart;
    }
    
    public List<CartEntity> listComponent(){
        return cart;
    }
    public void setComponent(List<CartEntity> cart){
        this.cart = cart;
    }
    
    public void addComponent(CartEntity orderDetail){
        cart.add(orderDetail);
    }
    public int getCount(){
        return  cart.size();
    }
//    public void removeComponent(CartEntity cartEntity){
//        
//        for(int i=0; i<cart.size(); i++){
//            CartEntity order = cart.get(i);
//            if(order.getFlightID()==cartEntity.getFlightID()){
//                cart.remove(i);
//                return;
//            }
//        }
//    }
    public void removeComponent(String seatNumber){
        
        for(int i=0; i<cart.size(); i++){
            CartEntity order = cart.get(i);
            if(order.getSeat().equals(seatNumber)){
                cart.remove(i);
                return;
            }
        }
    }
}
