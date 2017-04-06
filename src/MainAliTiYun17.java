
public class MainAliTiYun17 {
	public static void main(String[] args) {
		Driver d = new Driver();
		Carriage carriage = new Carriage();
		Bus bus = new Bus();
		d.driver(carriage);//司机开轿车
		d.driver(bus);//司机开客车
		
	}
	
}

abstract class Car{
	public abstract void run();
}
class Carriage extends Car{

	@Override
	public void run() {
		//
		System.out.println("轿车开动...");
	}
}
class Bus extends Car{
	
	@Override
	public void run() {
		//
		System.out.println("客车开动...");
	}
}
class Driver{
	
	public void driver(Car car){
		System.out.println("司机启动汽车...");
		car.run();
	}
}


