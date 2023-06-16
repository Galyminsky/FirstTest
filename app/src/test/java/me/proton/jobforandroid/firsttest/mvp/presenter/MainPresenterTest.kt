package me.proton.jobforandroid.firsttest.mvp.presenter


import me.proton.jobforandroid.firsttest.mvp.model.User
import org.junit.Assert
import org.junit.Test

class MainPresenterTest {

    @Test
    fun emailsAreEqualMethod_equalEmails_ReturnsTrue() {
        Assert.assertEquals(true, MainPresenter().emailsAreEqual("vasya@email.ru", "vasya@email.ru") )
    }

    @Test
    fun emailsAreEqualMethod_notEqualEmails_ReturnsFalse() {
        Assert.assertNotEquals(true, MainPresenter().emailsAreEqual("vasya@email.ru", "petya@email.ru") )
    }

    @Test
    fun isNameValid_emptyName_returnsFalse(){
        Assert.assertFalse(MainPresenter().isNameValid(""))
    }

    @Test
    fun isNameValid_nameStartsWithDigit_returnsFalse(){
        Assert.assertFalse(MainPresenter().isNameValid("1asya"))
    }

    @Test
    fun isNameValid_nameContainsDigit_returnsFalse(){
        Assert.assertFalse(MainPresenter().isNameValid("vas1ya"))
    }

    @Test
    fun saveButtonClicked_emailNotValid_returnsNull() {
        Assert.assertNull(MainPresenter().saveButtonClicked(false, "vasya@email.ru", "vasya@email.ru", "Vasya"))
    }

    @Test
    fun saveButtonClicked_emailsNotEqual_returnsNull() {
        Assert.assertNull(MainPresenter().saveButtonClicked(true, "vasya@email.ru", "vasy@email.ru", "Vasya"))
    }

    @Test
    fun saveButtonClicked_nameNotValid_returnsNull() {
        Assert.assertNull(MainPresenter().saveButtonClicked(true, "vasya@email.ru", "vasya@email.ru", "1asya"))
    }

    @Test
    fun saveButtonClicked_allOk_returnsNotNull() {
        Assert.assertNotNull(MainPresenter().saveButtonClicked(true, "vasya@email.ru", "vasya@email.ru", "Vasya"))
    }

    @Test
    fun makeFirstLetterOfNameUppercase_returnsNameWithUppercaseFirstLetter() {
        Assert.assertEquals("Vasya", MainPresenter().makeFirstLetterOfNameUppercase("vasya"))
    }

    @Test
    fun registrateUser_returnsSameObject(){
        val user = User("vasya", "vasya@vasya.ru")
        Assert.assertSame(user, MainPresenter().registrateUser(user) )
    }
}