
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Customer c  = new Customer();
		c.setSno(1);
		c.setName("Isha");
		c.setEmail("isha@gmail.com");
		
		System.out.println(c);
		
		Address addr = new Address();
		addr.setDoorno(1);
		addr.setCityName("Hyderabad");
		addr.setStreetAddr("MG Road");
		addr.setPincode("500001");
		
		System.out.println(addr);
		
		
		c.setAddr(addr);
		System.out.println(" after setting address obj to customer obj ");
		System.out.println(c);
		
	}

}
