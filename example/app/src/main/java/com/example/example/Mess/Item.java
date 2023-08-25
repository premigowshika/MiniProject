package com.example.example.Mess;

import android.view.View;
import android.widget.RatingBar;

import java.util.ArrayList;
import java.util.Calendar;


@SuppressWarnings({"unused", "WeakerAccess"})
public class Item {

    private String messPart;
    private String messTime;
    private String messItems;
    private String messRatings;
    private int day;

    private View.OnClickListener submitBtnClickListener;
    private RatingBar.OnRatingBarChangeListener ratingBarChangeListener;

    public Item() {
    }

    public Item(int day,String messPart, String messTime, String messItems, String messRatings) {
        this.day=day;
        this.messPart = messPart;
        this.messTime = messTime;
        this.messItems = messItems;
        this.messRatings = messRatings;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getMessPart() {
        return messPart;
    }

    public void setMessPart(String messPart) {
        this.messPart = messPart;
    }

    public String getMessTime() {
        return messTime;
    }

    public void setMessTime(String messTime) {
        this.messTime = messTime;
    }

    public String getMessItems() {
        return messItems;
    }

    public void setMessItems(String messItems) {
        this.messItems = messItems;
    }

    public String getMessRatings() {
        return messRatings;
    }

    public void setMessRatings(String messRatings) {
        this.messRatings = messRatings;
    }

    public View.OnClickListener getSubmitBtnClickListener() {
        return submitBtnClickListener;
    }

    public void setSubmitBtnClickListener(View.OnClickListener requestBtnClickListener) {
        this.submitBtnClickListener = requestBtnClickListener;
    }

    public RatingBar.OnRatingBarChangeListener getRatingBarClickListener() {

        return ratingBarChangeListener;
    }

    public void setRatingBarClickListener(RatingBar.OnRatingBarChangeListener ratingBarClickListener) {
        this.ratingBarChangeListener = ratingBarClickListener;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (messPart != null ? !messPart.equals(item.messPart) : item.messPart != null)
            return false;
        if (messTime != null ? !messTime.equals(item.messTime) : item.messTime != null)
            return false;
        if (messItems != null ? !messItems.equals(item.messItems) : item.messItems != null)
            return false;


        return messRatings != null ? messRatings.equals(item.messRatings) : item.messRatings == null;

    }

    @Override
    public int hashCode() {
        int result = messPart != null ? messPart.hashCode() : 0;
        result = 31 * result + (messTime != null ? messTime.hashCode() : 0);
        result = 31 * result + (messItems != null ? messItems.hashCode() : 0);
        result = 31 * result + (messRatings != null ? messRatings.hashCode() : 0);

        return result;
    }

    public static ArrayList<Item> makeMenu(int index) {

        ArrayList<Item> sundayMenu = new ArrayList<>();
        ArrayList<Item> mondayMenu = new ArrayList<>();
        ArrayList<Item> tuesdayMenu = new ArrayList<>();
        ArrayList<Item> wednesdayMenu = new ArrayList<>();
        ArrayList<Item> thursdayMenu = new ArrayList<>();
        ArrayList<Item> fridayMenu = new ArrayList<>();
        ArrayList<Item> saturdayMenu = new ArrayList<>();

        sundayMenu.add(new Item(0,"B\nR\nE\nA\nK\nF\nA\nS\nT", "7:30 - 8:45 am", "" + "Bread,\n" + "Jam,\n" + "Chana Masala,\n" + "Omelette,\n" + "Coffee.", null));
        sundayMenu.add(new Item(0,"L\nU\nN\nC\nH\n", "12:30 - 1:50 am", "" + "Steamed Rice,\n" + "Sothi Kuzhambu,\n" + "Potato,\n" + "Rasam,\n" + "Buttermilk,\n" + "Papad,\n" + "Pickle.", null));
        sundayMenu.add(new Item(0,"S\nN\nA\nC\nK\nS", "4:30 - 5:30 pm", "" + "Bread,\n" + "Tea,\n" +"Milk.", null));
        sundayMenu.add(new Item(0,"D\nI\nN\nN\nE\nR", "7:00 - 8:00 pm", "" + "Dosa,\n" + "Sambar,\n" + "Coconut Chutney.", null));

        mondayMenu.add(new Item(1,"B\nR\nE\nA\nK\nF\nA\nS\nT", "7:30 - 8:45 am", "" + "Idli,\n"+"Coconut Chutney,\n"+ "Sambhar ,\n"+ "Kesari,\n"+ "Coffee.", null));
        mondayMenu.add(new Item(1,"L\nU\nN\nC\nH\n", "12:50 - 1:50 pm", "" + "Steamed Rice,\n" + "Sambar,\n" + "Carrot Beans Poriyal,\n" + "Rasam,\n" + "Buttermilk,\n" +"Papad,\n" + "Pickle." , null));
        mondayMenu.add(new Item(1,"S\nN\nA\nC\nK\nS", "4:30 - 5:30 pm", "" + "Biscuit,\n" + "Tea,\n" + "Milk.", null));
        mondayMenu.add(new Item(1,"D\nI\nN\nN\nE\nR", "7:00 - 8:00 pm", "" + "Parotta,\n" + "Chicken Masala,\n" + "Chicken Gravy,\n" + "Paneer Masala." , null));

        tuesdayMenu.add(new Item(2,"B\nR\nE\nA\nK\nF\nA\nS\nT", "7:30 - 8:45 am", "" + "Pongal,\n" + "Sambar,\n" + "Coconut Chutney,\n" + "Uluntha Vada.", null));
        tuesdayMenu.add(new Item(2,"L\nU\nN\nC\nH\n", "12:50 - 1:50 pm", "" + "Steamed Rice,\n" + "Puzhikuzhambu,\n" + "Cabbage Peas Poriyal,\n" + "Rasam,\n" +"ButterMilk,\n"+ "Pickle.", null));
        tuesdayMenu.add(new Item(2,"S\nN\nA\nC\nK\nS", "4:30 - 5:30 pm", "" + "Paruppu Vada,\n" + "Tea,\n" + "Milk.", null));
        tuesdayMenu.add(new Item(2,"D\nI\nN\nN\nE\nR", "7:00 - 8:00 pm", "" + "Idly,\n" + "Sambar,\n" + "Coconut Chutney.", null));


        wednesdayMenu.add(new Item(3,"B\nR\nE\nA\nK\nF\nA\nS\nT", "7:30 - 8:45 am", "" + "Semiya Upma,\n" + "Coconut Chutney,\n" + "Bajji,\n" + "Coffee.", null));
        wednesdayMenu.add(new Item(3,"L\nU\nN\nC\nH\n", "12:50 - 1:50 pm", "" + "Steamed Rice,\n" + "Morkuzhambu,\n" +"Egg Curry,\n" + "Potato Fry,\n" + "Papad,\n" + "Rasam,\n" + "Buttermilk.", null));
        wednesdayMenu.add(new Item(3,"S\nN\nA\nC\nK\nS", "4:30 - 5:30 pm", "" + "Steamed Green gram \n" + "Tea,\n" + "Milk.", null));
        wednesdayMenu.add(new Item(3,"D\nI\nN\nN\nE\nR", "7:00 - 8:00 pm", "" + "Chapathi,\n" + "Veg Kurma,\n" + "Curd Rice." , null));

        thursdayMenu.add(new Item(4,"B\nR\nE\nA\nK\nF\nA\nS\nT", "7:30 - 8:45 am", "" + "Idly,\n" + "Sambar,\n" + "Coconut Chutney,\n" + "Paruppu Vada,\n" + "Coffee." , null));
        thursdayMenu.add(new Item(4,"L\nU\nN\nC\nH\n", "12:50 - 1:50 pm", "" + "Kushka,\n" + "Chicken curry,\n" + "Chicken 65,\n" + "Steamed Rice,\n" + "Veg Curry,\n" + "Caulifolwer Fry,\n" + "Rasam,\n" +"Papad.", null));
        thursdayMenu.add(new Item(4,"S\nN\nA\nC\nK\nS", "4:30 - 5:30 pm", "" + "Bajji,\n" + "Tea," + "Milk.", null));
        thursdayMenu.add(new Item(4,"D\nI\nN\nN\nE\nR", "7:00 - 8:00 pm", "" + "Tomato Rice,\n" + "Coconut chutney,\n" + "Papad." , null));

        fridayMenu.add(new Item(5,"B\nR\nE\nA\nK\nF\nA\nS\nT", "7:30 - 8:45 am", "" + "Dosa,\n" + "Coconut Chutney,\n" + "Uluntha Vada,\n" + "Coffee." , null));
        fridayMenu.add(new Item(5,"L\nU\nN\nC\nH\n", "12:50 - 1:50 pm", "" + "Steamed Rice,\n" + "Sambar,\n" + "Aviyal,\n" + "Payasam,\n" + "Rasam,\n" + "Papad,\n" + "Buttermilk." , null));
        fridayMenu.add(new Item(5,"S\nN\nA\nC\nK\nS", "4:30 - 5:30 pm", "" + "Veg Puffs,\n" + "Tea,\n" + "Milk.", null));
        fridayMenu.add(new Item(5,"D\nI\nN\nN\nE\nR", "7:00 - 8:00 pm", "" + "Chapathi,\n" + "Veg Kurma,\n" + "Curd Rice." , null));

        saturdayMenu.add(new Item(6,"B\nR\nE\nA\nK\nF\nA\nS\nT", "7:30 - 8:45 am", "" + "Poori,\n" + "Potato Masala,\n" + "Coffee." , null));
        saturdayMenu.add(new Item(6,"L\nU\nN\nC\nH\n", "12:50 - 1:50 pm", "" + "Steamed Rice,\n" + "Paruppu Kuzhambu,\n" + "Potato soyachunks masala,\n" + "Rasam,\n" + "Buttermilk,\n" + "Papad." , null));
        saturdayMenu.add(new Item(6,"S\nN\nA\nC\nK\nS", "4:30 - 5:30 pm", "" + "Uluntha Vada,\n" + "Tea,\n" + "Milk.", null));
        saturdayMenu.add(new Item(6,"D\nI\nN\nN\nE\nR", "7:00 - 8:00 pm", "" + "Fried Rice,\n" + "Cauliflower Curry,\n" + "Papad." , null));

        switch (index) {
            case 0:
                return sundayMenu;

            case 1:
                return mondayMenu;

            case 2:

                return tuesdayMenu;

            case 3:
                return wednesdayMenu;

            case 4:
                return thursdayMenu;

            case 5:
                return fridayMenu;

            case 6: {
                return saturdayMenu;
            }

            default:
                return sundayMenu;


        }
    }
    /**
     * @return List of elements prepared for tests
     */
    public static ArrayList<Item> getTestingList() {
        ArrayList<Item>sunday = new ArrayList<>();
        ArrayList<Item>monday = new ArrayList<>();
        ArrayList<Item>tuesday = new ArrayList<>();
        ArrayList<Item>wednesday = new ArrayList<>();
        ArrayList<Item>thursday = new ArrayList<>();
        ArrayList<Item>friday = new ArrayList<>();
        ArrayList<Item>saturday = new ArrayList<>();

        sunday.add(new Item(0,"B\nR\nE\nA\nK\nF\nA\nS\nT", "7:30 - 8:45 am", "" + "Bread,\n" + "Jam,\n" + "Chana Masala,\n" + "Omelette,\n" + "Coffee.", null));
        sunday.add(new Item(0,"L\nU\nN\nC\nH\n", "12:50 - 1:50 pm", "" + "Steamed Rice,\n" + "Sothi Kuzhambu,\n" + "Potato,\n" + "Rasam,\n" + "Buttermilk,\n" + "Papad,\n" + "Pickle.", null));
        sunday.add(new Item(0,"S\nN\nA\nC\nK\nS", "4:30 - 5:30 pm", "" + "Bread,\n" + "Tea,\n" +"Milk.", null));
        sunday.add(new Item(0,"D\nI\nN\nN\nE\nR", "7:00 - 8:00 pm", "" + "Dosa,\n" + "Sambar,\n" + "Coconut Chutney.", null));

        monday.add(new Item(1,"B\nR\nE\nA\nK\nF\nA\nS\nT", "7:30 - 8:45 am", "" + "Idli,\n"+"Coconut Chutney,\n"+ "Sambhar ,\n"+ "Kesari,\n"+ "Coffee.", null));
        monday.add(new Item(1,"L\nU\nN\nC\nH\n", "12:50 - 1:50 pm", "" + "Steamed Rice,\n" + "Sambar,\n" + "Carrot Beans Poriyal,\n" + "Rasam,\n" + "Buttermilk,\n" +"Papad,\n" + "Pickle." , null));
        monday.add(new Item(1,"S\nN\nA\nC\nK\nS", "4:30 - 5:30 pm", "" + "Biscuit,\n" + "Tea,\n" + "Milk.", null));
        monday.add(new Item(1,"D\nI\nN\nN\nE\nR", "7:00 - 8:00 pm", "" + "Parotta,\n" + "Chicken Masala,\n" + "Chicken Gravy,\n" + "Paneer Masala." , null));

        tuesday.add(new Item(2,"B\nR\nE\nA\nK\nF\nA\nS\nT", "7:30 - 8:45 am", "" + "Pongal,\n" + "Sambar,\n" + "Coconut Chutney,\n" + "Uluntha Vada.", null));
        tuesday.add(new Item(2,"L\nU\nN\nC\nH\n", "12:50 - 1:50 pm", "" + "Steamed Rice,\n" + "Puzhikuzhambu,\n" + "Cabbage Peas Poriyal,\n" + "Rasam,\n" +"ButterMilk,\n"+ "Pickle.", null));
        tuesday.add(new Item(2,"S\nN\nA\nC\nK\nS", "4:30 - 5:30 pm", "" + "Paruppu Vada,\n" + "Tea,\n" + "Milk.", null));
        tuesday.add(new Item(2,"D\nI\nN\nN\nE\nR", "7:00 - 8:00 pm", "" + "Idly,\n" + "Sambar,\n" + "Coconut Chutney.", null));


        wednesday.add(new Item(3,"B\nR\nE\nA\nK\nF\nA\nS\nT", "7:30 - 8:45 am", "" + "Semiya Upma,\n" + "Coconut Chutney,\n" + "Bajji,\n" + "Coffee.", null));
        wednesday.add(new Item(3,"L\nU\nN\nC\nH\n", "12:50 - 1:50 pm", "" + "Steamed Rice,\n" + "Morkuzhambu,\n" +"Egg Curry,\n" + "Potato Fry,\n" + "Papad,\n" + "Rasam,\n" + "Buttermilk.", null));
        wednesday.add(new Item(3,"S\nN\nA\nC\nK\nS", "4:30 - 5:30 pm", "" + "Steamed Green gram \n" + "Tea,\n" + "Milk.", null));
        wednesday.add(new Item(3,"D\nI\nN\nN\nE\nR", "7:00 - 8:00 pm", "" + "Chapathi,\n" + "Veg Kurma,\n" + "Curd Rice." , null));

        thursday.add(new Item(4,"B\nR\nE\nA\nK\nF\nA\nS\nT", "7:30 - 8:45 am", "" + "Idly,\n" + "Sambar,\n" + "Coconut Chutney,\n" + "Paruppu Vada,\n" + "Coffee." , null));
        thursday.add(new Item(4,"L\nU\nN\nC\nH\n", "12:50 - 1:50 pm", "" + "Kushka,\n" + "Chicken curry,\n" + "Chicken 65,\n" + "Steamed Rice,\n" + "Veg Curry,\n" + "Caulifolwer Fry,\n" + "Rasam,\n" +"Papad.", null));
        thursday.add(new Item(4,"S\nN\nA\nC\nK\nS", "4:30 - 5:30 pm", "" + "Bajji,\n" + "Tea," + "Milk.", null));
        thursday.add(new Item(4,"D\nI\nN\nN\nE\nR", "7:00 - 8:00 pm", "" + "Tomato Rice,\n" + "Coconut chutney,\n" + "Papad." , null));

        friday.add(new Item(5,"B\nR\nE\nA\nK\nF\nA\nS\nT", "7:30 - 8:45 am", "" + "Dosa,\n" + "Coconut Chutney,\n" + "Uluntha Vada,\n" + "Coffee." , null));
        friday.add(new Item(5,"L\nU\nN\nC\nH\n", "12:50 - 1:50 pm", "" + "Steamed Rice,\n" + "Sambar,\n" + "Aviyal,\n" + "Payasam,\n" + "Rasam,\n" + "Papad,\n" + "Buttermilk." , null));
        friday.add(new Item(5,"S\nN\nA\nC\nK\nS", "4:30 - 5:30 pm", "" + "Veg Puffs,\n" + "Tea,\n" + "Milk.", null));
        friday.add(new Item(5,"D\nI\nN\nN\nE\nR", "7:00 - 8:00 pm", "" + "Chapathi,\n" + "Veg Kurma,\n" + "Curd Rice." , null));

        saturday.add(new Item(6,"B\nR\nE\nA\nK\nF\nA\nS\nT", "7:30 - 8:45 am", "" + "Poori,\n" + "Potato Masala,\n" + "Coffee." , null));
        saturday.add(new Item(6,"L\nU\nN\nC\nH\n", "12:50 - 1:50 pm", "" + "Steamed Rice,\n" + "Paruppu Kuzhambu,\n" + "Potato soyachunks masala,\n" + "Rasam,\n" + "Buttermilk,\n" + "Papad." , null));
        saturday.add(new Item(6,"S\nN\nA\nC\nK\nS", "4:30 - 5:30 pm", "" + "Uluntha Vada,\n" + "Tea,\n" + "Milk.", null));
        saturday.add(new Item(6,"D\nI\nN\nN\nE\nR", "7:00 - 8:00 pm", "" + "Fried Rice,\n" + "Cauliflower Curry,\n" + "Papad." , null));

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        switch (day) {
            case Calendar.SUNDAY:
                // Current day is Sunday
                return sunday;

            case Calendar.MONDAY:
                // Current day is Monday
                return monday;

            case Calendar.TUESDAY:
                // etc.
                return tuesday;

            case Calendar.WEDNESDAY:
                return wednesday;

            case Calendar.THURSDAY:
                return thursday;

            case Calendar.FRIDAY:
                return friday;

            case Calendar.SATURDAY:{
                return saturday;
            }

                default:return sunday;



        }



    }

}
