package com.nk.demogithubautomation.presenter;

import com.nk.demogithubautomation.database.ExpenseDatabaseHelper;
import com.nk.demogithubautomation.model.ExpenseType;
import com.nk.demogithubautomation.view.AddCategoryView;

public class CategoryPresenter {
  private final AddCategoryView view;
  private final ExpenseDatabaseHelper database;

  public CategoryPresenter(AddCategoryView view, ExpenseDatabaseHelper database) {
    this.view = view;
    this.database = database;
  }

  public boolean addCategory() {
    String newCategory = view.getCategory();
    if(newCategory.isEmpty()){
      view.displayError();
      return false;
    }

    database.addExpenseType(new ExpenseType(newCategory));
    return true;
  }
}
