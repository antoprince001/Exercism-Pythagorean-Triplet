import java.util.*;
class PythagoreanTriplet{

    int a, b, c; 
    PythagoreanTriplet(int a,int b,int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PythagoreanTriplet)) return false;
        PythagoreanTriplet other = (PythagoreanTriplet) o;
        return a == other.a &&
               b == other.b &&
               c == other.c;
    }
    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    static PythagoreanTripletBuilder makeTripletsList() {
        return new PythagoreanTripletBuilder();
    }
    
    static class PythagoreanTripletBuilder{

        int sum,maximum;
        PythagoreanTripletBuilder  thatSumTo(int value){
            this.sum = value;
            return this;
        }
    
        PythagoreanTripletBuilder withFactorsLessThanOrEqualTo(int value){
            this.maximum = value;
            return this;
        }

    
        List<PythagoreanTriplet> build(){

            List<PythagoreanTriplet> triples = new ArrayList<PythagoreanTriplet>(); 
        
            for(int a=1;a<=maximum/2;a++){
                for(int b=a+1;b<=(maximum-a)/2;b++){
                            if(b!=a){
                                int c = sum - a - b;
                                if(a*a + b*b == c*c){
                                    triples.add(new PythagoreanTriplet(a, b, c));

                                }
                            }
                        
                }
            }
            
            return triples;
        }
    }
}
