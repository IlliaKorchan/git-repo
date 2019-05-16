package com.company.controller;

import com.company.model.entity.NotUniqueLoginException;
import com.company.model.entity.NoteBook;
import com.company.model.services.Check;
import com.company.model.services.Checker;
import com.company.view.View;

import java.util.Scanner;

/**
 * Created by student on 26.09.2017.
 */
public class Controller {
    private View view;
    private Scanner sc = new Scanner(System.in);
    private Check checker = new Checker();

    public Controller(View view) {
        this.view = view;
    }

    public void processUser() {
        InputNoteNoteBook inputNoteNoteBook = new InputNoteNoteBook(view, sc);
        inputNoteNoteBook.inputName();

        NoteBook noteBook;
        while(true) {
            inputNoteNoteBook.inputLogin();
            try {
                if (checker.checkLogin(inputNoteNoteBook.getLoginData())) {
                    noteBook = new NoteBook(inputNoteNoteBook.getFirstName(),
                            inputNoteNoteBook.getLoginData());
                    break;
                }
            } catch (NotUniqueLoginException e) {
                System.out.println("Not Unique Login " + e.getLoginData());

            }
        }
        System.out.println(noteBook);

    }
}
