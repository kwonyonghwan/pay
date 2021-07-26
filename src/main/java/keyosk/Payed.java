package keyosk;

public class Payed extends AbstractEvent {

    private Long orderId;
    private Integer totalPrice;
    private Long payMethod;
    private Integer cardNumber;
    private String orderStatus;

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


    public Payed(){
        super();
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
		return "Payed [orderId=" + orderId + ", totalPrice=" + totalPrice + ", orderStatus=" + orderStatus + ", payMethod=" + payMethod
				+ ", cardNumber=" + cardNumber + "]";
	}

}
