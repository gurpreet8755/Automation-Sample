package com.nk.demogithubautomation.view;

import java.util.List;

import com.nk.demogithubautomation.model.Expense;

public interface TodaysExpenseView {
  void displayTotalExpense(Long totalExpense);
  void displayTodaysExpenses(List<Expense> expenses);
}
