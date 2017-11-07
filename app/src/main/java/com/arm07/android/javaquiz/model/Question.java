package com.arm07.android.javaquiz.model;

import java.util.ArrayList;

/**
 * Created by rashmi on 11/6/2017.
 */

// POJO for Questions (Model Class)

public class Question
{
    private int questionId;
    private String question;
    private String options1;
    private String options2;
    private String options3;
    private String options4;
    private String correctAnswer;
   private String answerExplanation;

   private static ArrayList<Question> mQuizQuestionsArrayList;

    public Question()
    {
    }

    public Question(int questionId, String question, String options1, String options2, String options3, String options4, String correctAnswer, String answerExplanation)
    {
        this.questionId = questionId;
        this.question = question;
        this.options1 = options1;
        this.options2 = options2;
        this.options3 = options3;
        this.options4 = options4;
        this.correctAnswer = correctAnswer;
        this.answerExplanation = answerExplanation;
    }

    public String getCorrectAnswer()
    {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer)
    {
        this.correctAnswer = correctAnswer;
    }

    public int getQuestionId()
    {
        return questionId;
    }

    public void setQuestionId(int questionId)
    {
        this.questionId = questionId;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public String getOptions1()
    {
        return options1;
    }

    public void setOptions1(String options1)
    {
        this.options1 = options1;
    }

    public String getOptions2()
    {
        return options2;
    }

    public void setOptions2(String options2)
    {
        this.options2 = options2;
    }

    public String getOptions3()
    {
        return options3;
    }

    public void setOptions3(String options3)
    {
        this.options3 = options3;
    }

    public String getOptions4()
    {
        return options4;
    }

    public void setOptions4(String options4)
    {
        this.options4 = options4;
    }



    public String getAnswerExplanation()
    {
        return answerExplanation;
    }

    public void setAnswerExplanation(String answerExplanation)
    {
        this.answerExplanation = answerExplanation;
    }


    public static  ArrayList<Question> getQuizQuestionsArrayList()
    {
        return mQuizQuestionsArrayList;
    }


    public static void initData()
    {
        mQuizQuestionsArrayList = new ArrayList<>();
        mQuizQuestionsArrayList.add(new Question(1,"How to pass the data between activities in Android?","Intent","Content Provider","Broadcast receiver","None of the Above","Intent","An Intent is used to connect one activity to another activity and having a message passing mechanism between activities."));
        mQuizQuestionsArrayList.add(new Question(2,"How many sizes are supported by Android?","Android supported all sizes","Android does not support all sizes","Android supports small,normal, large and extra-large sizes","Size is undefined in android","ndroid supports small,normal, large and extra-large sizes","X-large screens are having at least 960dp*720dp resolutions\n" +
                "\n" +
                "Large screens are having at least 640dp*480dp resolutions\n" +
                "\n" +
                "Normal screens are having at least 470dp*320dp resolutions\n" +
                "\n" +
                "Small screens are having at least 426dp*320dp resolutions"));
        mQuizQuestionsArrayList.add(new Question(3,"What is broadcast receiver in android?","It will react on broadcast announcements.","It will do background functionalities as services.","It will pass the data between activities.","None of the Above","It will react on broadcast announcements.","It is a main component of android. It reacts on the system broadcast announcements, and it acts as a gateway between outside application environment with your application."));
        mQuizQuestionsArrayList.add(new Question(4,"How to store heavy structured data in android?","Shared Preferences","Cursor","SQlite database","Not possible","SQlite database","We can store structured data in SQlite database only. SQlite database is very efficient and faster to read and store the data."));
        mQuizQuestionsArrayList.add(new Question(5,"How to get current location in android?","Using with GPRS","Using location provider","A & B","Network servers","A & B","GPRS and Location provider is used to fetch the current location of a phone as longitude and latitude."));
        mQuizQuestionsArrayList.add(new Question(6,"What is DDMS in android?","Dalvik memory server","Device memory server","Dalvik monitoring services","Dalvik debug monitor services","Dalvik debug monitor services","DDMS provides port forwarding, screen capturing, memory mapping, logcat, calls, SMS etc."));
        mQuizQuestionsArrayList.add(new Question(7,"What are the functionalities of HTTP Client interface in android?","Connection management","Cookies management","Authentication management","All of the above","All of the above","HTTP Client has the capabilities to manage connections, cookies and Authentication."));
        mQuizQuestionsArrayList.add(new Question(8,"How many orientations does android support?","4","10","2","None of the Above","4","According to the Google documentation, Android supports 4 types of orientations, those are landscape, portrait, sensor and No orientation"));
        mQuizQuestionsArrayList.add(new Question(9,"How many protection levels are available in the android permission tag?","There are no permission tags available in android","Normal, kernel, application","Normal, dangerous, signature, and signatureOrsystem","None of the Above","Normal, dangerous, signature, and signatureOrsystem","Android is having four levels of protection in android permission tag. They are normal, dangerous, signature, and signatureOrsystem"));
        mQuizQuestionsArrayList.add(new Question(10,"What is anchor view?","Same as list view","provides the information on respective relative positions","Same as relative layout","None of the Above","provides the information on respective relative positions","Anchor View provides the information on respective relative positions of views."));

    }

}
