package ru.frigesty.tests;

import org.junit.jupiter.api.Test;
import ru.frigesty.pages.RegistrationPage;

public class HomeTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    GenerationData gD = new GenerationData();

    @Test
    void practiceFormTest() {

        registrationPage.openPage()
                        .removeFooter()
                        .setFirstName(gD.firstName)
                        .setLastName(gD.lastName)
                        .userEmailName(gD.userEmail)
                        .chooseGender(gD.userGender)
                        .userMobileNumber(gD.userNumber)
                        .chooseBirthDate(gD.dayOfBirth, gD.monthOfBirth, gD.yearOfBirth)
                        .writeAndChooseSubject(gD.subject)
                        .chooseHobbies(gD.hobbies)
                        .uploadPicture(gD.pictures)
                        .setAddressName(gD.currentAddress)
                        .chooseStateAndCity(gD.randomState, gD.randomCity)
                        .clickSubmit();

        registrationPage.verifyRegistrationResultsModalAppears()
                        .verifyResult("Student Name", gD.firstName + " " + gD.lastName)
                        .verifyResult("Student Email", gD.userEmail)
                        .verifyResult("Gender", gD.userGender)
                        .verifyResult("Mobile", gD.userNumber)
                        .verifyResult("Date of Birth", gD.dayOfBirth + " " + gD.monthOfBirth + "," + gD.yearOfBirth)
                        .verifyResult("Subjects", gD.subject)
                        .verifyResult("Hobbies", gD.hobbies)
                        .verifyResult("Picture", gD.pictures)
                        .verifyResult("Address", gD.currentAddress)
                        .verifyResult("State and City", gD.randomState + " " + gD.randomCity);
    }
}