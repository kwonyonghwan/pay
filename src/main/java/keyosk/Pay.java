package keyosk;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Pay_table")
public class Pay {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long orderId;
    private String orderStatus;
    private Integer totalPrice;
    private Long payMethod;
    private Integer cardNumber;

    @PostPersist
    public void onPostPersist(){

        Payed payed = new Payed();
        BeanUtils.copyProperties(this, payed);
        payed.setOrderId(this.orderId);
        payed.setOrderStatus(this.orderStatus);

         System.out.println(" onPostPersist PUBLISH:   " +payed.toString());
         payed.publishAfterCommit();

    }

    @PostUpdate
    public void onPostUpdate(){


        if(this.orderStatus=="PAYED"){

            Payed payed = new Payed();
            BeanUtils.copyProperties(this, payed);
           // payed.publishAfterCommit();
    
           payed.setOrderId(this.orderId);
           payed.setTotalPrice(this.totalPrice);
           payed.setOrderStatus(this.orderStatus);
    
            System.out.println(" onPostUpdate PUBLISH:  " +payed.toString());
    
            payed.publishAfterCommit();

        }else if(this.orderStatus=="PAY CANCELLED"){

            PayCancelled payCancelled = new PayCancelled();
            BeanUtils.copyProperties(this, payCancelled);
           // payed.publishAfterCommit();
    
           payCancelled.setOrderId(this.orderId);
           payCancelled.setOrderStatus(this.orderStatus);

            System.out.println(" onPostUpdate PUBLISH:  " +payCancelled.toString());
    
            payCancelled.publishAfterCommit();

        }


    }


    public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Integer getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getPayMethod() {
		return this.payMethod;
	}

	public void setPayMethod(Long payMethod) {
		this.payMethod = payMethod;
	}

	public Integer getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}

    @Override
	public String toString() {
		return "PAY [orderId=" + orderId + ", totalPrice=" + totalPrice + ", orderStatus=" + orderStatus + ", payMethod=" + payMethod
				+ ", cardNumber=" + cardNumber + "]";
	}



}
