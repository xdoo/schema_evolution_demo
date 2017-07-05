package de.muenchen.jfs2017.demoproducer;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author claus
 */
@RestController
@Log
@RequiredArgsConstructor
public class OrderController {
    
    private final OrderService service;
    
    /**
     * convenience method for playing around 
     * 
     * @return 
     */
    @GetMapping("/order/random")
    public Order placeRandomOrder() {
        Order order = this.createRandomOrder();
        this.service.order(order);
        return order;
    }
    
    /**
     * create a new order
     * 
     * @param order
     * @return 
     */
    @PostMapping("/order")
    @SneakyThrows
    public ResponseEntity<OrderResource> createOrder(@RequestBody Order order) {
        
        // this is a hack for demo and not a unique id :)
        String id = RandomStringUtils.randomAlphanumeric(25);
        
        // send to backend
        this.service.order(order);
        
        // create links
        OrderResource orderR = this.createFromOrderResource(order);
        orderR.add(linkTo(methodOn(OrderController.class).readOrder(id)).withSelfRel());
        orderR.add(linkTo(methodOn(OrderController.class).updateOrder(order, id)).withRel("update_order"));
        orderR.add(linkTo(methodOn(OrderController.class).deleteOrder(id)).withRel("delete_order"));
        orderR.add(linkTo(methodOn(OrderController.class).payOrder(id)).withRel("pay_order"));
        
        return new ResponseEntity<>(orderR, HttpStatus.CREATED);


    }
    
    /**
     * read order by id
     * 
     * @param id
     * @return 
     */
    @GetMapping("/order/{id}")
    public ResponseEntity readOrder(@PathVariable("id") String id) {
        
        // this is a hack :) implement something useful
        Order order = this.createRandomOrder();
        
        // create links
        OrderResource orderR = this.createFromOrderResource(order);
        orderR.add(linkTo(methodOn(OrderController.class).readOrder(id)).withSelfRel());
        orderR.add(linkTo(methodOn(OrderController.class).updateOrder(order, id)).withRel("update_order"));
        orderR.add(linkTo(methodOn(OrderController.class).deleteOrder(id)).withRel("delete_order"));
        orderR.add(linkTo(methodOn(OrderController.class).payOrder(id)).withRel("pay_order"));
        
        return null;
    }
    
    /**
     * update order by id
     * 
     * @param order
     * @param id
     * @return 
     */
    @PatchMapping("/order/{id}")
    public ResponseEntity updateOrder(Order order, @PathVariable("id") String id) {
        
        // do something (not implemented)
        
        // create links
        OrderResource orderR = this.createFromOrderResource(order);
        orderR.add(linkTo(methodOn(OrderController.class).readOrder(id)).withSelfRel());
        orderR.add(linkTo(methodOn(OrderController.class).updateOrder(order, id)).withRel("update_order"));
        orderR.add(linkTo(methodOn(OrderController.class).deleteOrder(id)).withRel("delete_order"));
        orderR.add(linkTo(methodOn(OrderController.class).payOrder(id)).withRel("pay_order"));
        
        return new ResponseEntity(order, HttpStatus.OK);
    }
    
    /**
     * delete order by id
     * 
     * @param id
     * @return 
     */
    @DeleteMapping("/order/{id}")
    public ResponseEntity deleteOrder(@PathVariable("id") String id) {
        
        // do something... (not implemented)
        
        return new ResponseEntity(HttpStatus.OK);
    }
    
    /**
     * pay order by id
     * 
     * @param id
     * @return 
     */
    @PutMapping("/order/{id}/payment")
    public ResponseEntity payOrder(@PathVariable("id") String id) {
        
        // do something... (not implemented) 
        // add some links...
        
        return new ResponseEntity(HttpStatus.OK);
    }
    
    /**
     * helper method to create a simple order without typing
     * 
     * @return 
     */
    private Order createRandomOrder() {
        return Order.builder()
                .lineItem(LineItem.builder()
                        .name("Kaffee")
                        .quantity(RandomUtils.nextInt(10))
                        .milk(Boolean.TRUE)
                        .size("small").build())
                .lineItem(LineItem.builder()
                        .name("Kaffee")
                        .quantity(RandomUtils.nextInt(10))
                        .milk(Boolean.FALSE)
                        .size("medium").build())
                .build();
    }
    
    /**
     * mapping method from resource object to pojo 
     * 
     * @param orderR
     * @return 
     */
    private OrderResource createFromOrderResource(Order order) {
        return OrderResource.builder().lineItems(order.getLineItems()).build();
    }
    
}
