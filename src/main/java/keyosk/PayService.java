package keyosk;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
 public class PayService {     

    @Autowired PayRepository payRepository;
	 
   	/*----  POST-----order 주문 들어옴 */
	@Transactional
	public String savePayedService(Payed payedObj) throws Exception {

        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□ savePayedService start □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□"); 

		try {
			Pay payObj = new Pay();

			payObj.setOrderId(payedObj.getOrderId());
			payObj.setTotalPrice(payedObj.getTotalPrice());
			payObj.setOrderStatus("WAITING PAYED");

			payRepository.save(payObj);
	 
			//System.out.println(" OrderList data all :  " + orderRepository.findAll().toString());
	
			return "saver ORDER SUCCESS";
			
		} catch (Exception e) {
			return "saver ORDER Error" +e.getStackTrace();
		}
	}//orderPlacedService


	 
   	/*----  POST-----결제 됨   */
	   @Transactional
	   public String PayedService(Payed payedObj) throws Exception {
   
        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□ PayedService start □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□"); 

		   try {

			   Optional<Pay> tempObj =  payRepository.findById(payedObj.getOrderId());

			   Pay payObj = new Pay();
   
			   if(tempObj.isPresent()){
				   payObj = tempObj.get();		
			   }else{
				   return "no PAY data" ;
			   }
			   payObj.setOrderStatus("PAYED");
			   payObj.setPayMethod(payedObj.getPayMethod());//1:카드 2:현금 3:온라인 페이
			   payObj.setCardNumber(payedObj.getCardNumber());
			   
			   payRepository.save(payObj);

			   //System.out.println(" OrderList data all :  " + orderRepository.findAll().toString());
	   
			   return "PAYED SUCCESS";
			   
		   } catch (Exception e) {
			   return "save PAYED Error" +e.getStackTrace();
		   }
	   }//orderPlacedService




	@Transactional
	public String payCanceledService(PayCancelled payCancelledObj) throws Exception {

        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□ payCanceledService start □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□"); 

		try {
			Optional<Pay> tempObj =  payRepository.findById(payCancelledObj.getOrderId());

			Pay payObj = new Pay();

			if(tempObj.isPresent()){
				payObj = tempObj.get();		
			}else{
				return "no PAY data" ;
			}

			payObj.setOrderStatus("PAY CANCELLED");

			payRepository.save(payObj);
	
			System.out.println(" PAYLIST data all :  " + payRepository.findAll().toString());
	
			return "PAYCANCEL SUCCESS";
			
		} catch (Exception e) {
			return "PAYCANCEL ERROR" +e.getStackTrace();
		}
	}//payCanceledService


	@Transactional
	public Iterable<Pay> payListService() throws Exception {

        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□ payListService start □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□"); 

		try {

			return payRepository.findAll();
			
		} catch (Exception e) {

			System.out.println("payList Error" +e.getStackTrace());

			return null;
		}
	}//orderListService





 }//classPayService\
