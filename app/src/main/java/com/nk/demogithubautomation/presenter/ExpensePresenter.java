package com.nk.demogithubautomation.presenter;

import com.nk.demogithubautomation.database.ExpenseDatabaseHelper;
import com.nk.demogithubautomation.model.Expense;
import com.nk.demogithubautomation.view.ExpenseView;

import static com.nk.demogithubautomation.utils.DateUtil.getCurrentDate;

public class ExpensePresenter {

  private ExpenseDatabaseHelper database;
  private ExpenseView view;

  public ExpensePresenter(ExpenseDatabaseHelper expenseDatabaseHelper, ExpenseView view) {
    this.database = expenseDatabaseHelper;
    this.view = view;
  }

  public boolean addExpense() {
    String amount = view.getAmount();

    if(amount.isEmpty()) {
      view.displayError();
      return false;
    }

    Expense expense = new Expense(Long.valueOf(amount), view.getType(), getCurrentDate());
    database.addExpense(expense);
    return true;
  }

  public void setExpenseTypes() {
    view.renderExpenseTypes(database.getExpenseTypes());
  }
}
