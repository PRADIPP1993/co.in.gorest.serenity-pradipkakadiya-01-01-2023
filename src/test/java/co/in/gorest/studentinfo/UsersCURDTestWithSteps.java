package co.in.gorest.studentinfo;

import co.in.gorest.testbase.TestBase;
import co.in.gorest.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

/**
 * Created by Jay
 */
@RunWith(SerenityRunner.class)
public class UsersCURDTestWithSteps extends TestBase {

    static String Name = "PrimUser" + TestUtils.getRandomValue();
    //static String lastName = "PrimeUser" + TestUtils.getRandomValue();

    static String status = "active";
    static String gender = "male";
    static String email = TestUtils.getRandomValue() + "xyz@gmail.com";

    static int userId;


    @Steps
    UsersSteps usersSteps;

    @Title("This will create a new User")
    @Test
    public void test001() {

        ValidatableResponse response = usersSteps.createUsers( Name,email,gender, status);
        response.log().all().statusCode(201);

    }

    @Title("Verify if the User was added to the application")
    @Test
    public void test002() {
        HashMap<String, Object> studentMap = usersSteps.getUserInfoByemail(Name);
        Assert.assertThat(studentMap, hasValue(Name));
        userId = (int) studentMap.get("id");
    }

    @Title("Update the user information and verify the updated information")
    @Test
    public void test003() {
        Name = Name + "_updated";

        usersSteps.updateUser(email, Name, status, userId, gender).log().all().statusCode(200);

        HashMap<String, Object> userMap = usersSteps.getUserInfoByemail(Name);
        Assert.assertThat(userMap, hasValue(Name));
    }

    @Title("Delete the student and verify if the student is deleted!")
    @Test
    public void test004() {
        usersSteps.deleteuser(userId).statusCode(204);
        usersSteps.getuserById(userId).statusCode(404);
    }
}
