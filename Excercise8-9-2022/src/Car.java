public class Car extends Animal {



        private String color;
        private String color2;
        private int wheels;

        public Car(String color, int wheels, int legs, double weight)
        {

            this.color=color;
            this.wheels=wheels;
            this.legs=legs;
            this.weight=weight;

        }
        public void setColor(String y)
        {
                this.color=y;
        }
        //Overloaded
        public void setColor(String Z, String B)
        {
                this.color=Z;
                this.color2=B;
        }
        public void setWheels(int x)
        {
                this.wheels=x;
        }
        public String getColors()
        {
                return this.color;
        }
        public int getWheels()
        {
                return this.wheels;

        }

        //override
        @Override
        public void printer()
        {
                System.out.println("Byee!!!!!");

        }
}
