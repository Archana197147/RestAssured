import io.restassured.path.json.JsonPath;

public class ComplexJson {
    public static void main(String[] args){
        JsonPath js= new JsonPath(payload.CourseCount());
        //applicable only to array
        int count=js.getInt("courses.size()");
        System.out.println("Course count is : "+count);

        //purchase amount
        int purchaseAmount=js.getInt("dashboard.purchaseAmount");
        System.out.println("Purchase Amount is : "+purchaseAmount);

        //title of first book
        String FirstBookTitle=js.getString("courses[0].title");
        System.out.println("Title of first book is :" +FirstBookTitle);

        for(int i=0;i<count;i++){
            String courseTitle=js.get("courses["+i+"].title");
            String bookPrice=js.get("courses["+i+"].price").toString();
            System.out.println(courseTitle+ " : " +bookPrice);

            //number of copies by rpa
            String NumberOfCopiesRPA=js.getString("courses[2].copies");
            System.out.println("No of copies by RPA :" +NumberOfCopiesRPA);

            


        }



    }
}
