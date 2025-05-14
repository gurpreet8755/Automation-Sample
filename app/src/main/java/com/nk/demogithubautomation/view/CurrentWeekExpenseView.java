package com.nk.demogithubautomation.view;

import java.util.List;
import java.util.Map;

import com.nk.demogithubautomation.model.Expense;

public interface CurrentWeekExpenseView {
  void displayCurrentWeeksExpenses(Map<String, List<Expense>> expensesByDate);

  void displayTotalExpenses(Long totalExpense);
}
