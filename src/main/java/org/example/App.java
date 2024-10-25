package org.example;


public class App
{



    public static void main( String[] args )
    {
           TruckService truckService = new TruckService();

           Truck tata = new Truck("Tata","2019",1000,"Rajesh" );
           Truck volvo = new Truck("Volvo","2023",1000,"Pratham" );
           Truck eicher = new Truck("Eicher","2022",1000,"Harshit" );

           truckService.addTruck(tata);
           truckService.addTruck(volvo);
           truckService.addTruck(eicher);

           Truck truck = truckService.getTruckId(1);
            System.out.println("Truck Data " + truck);


    }
}
