import {expect} from 'chai';

describe('sandbox tests', () => {

  it('sandbox', () => {
    var daysInMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    var daysOfWeek = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
// var dayOfWeekMap = {"Sunday": 0, "Monday": 1, "Tuesday": 2, "Wednesday" : 3, "Thursday" : 4,
//                    "Friday" : 5, "Saturday" : 6, "Sunday" : 7};
    var monthDayCalc = [0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4];

    function recurringTask(firstDate, k, daysOfTheWeek, n) {
      var scheduledOccurrences = [];
      scheduledOccurrences.push(firstDate);

      for (var i = 1; i < n; i++) {
        scheduledOccurrences.push(
          getNextDate(scheduledOccurrences[scheduledOccurrences.length], k, daysOfTheWeek));
      }

      return scheduledOccurrences;
    }

    function getNextDate(currentDateStr, k, daysOfTheWeek) {
      var currentDate = parseDate(currentDateStr);
      var numDaysToAdd = numDaysTillNextOccurrence(currentDate, k, daysOfTheWeek);
      var newDate = addDaysToDate(currentDate, numDaysToAdd);
      return stringifyDate(newDate);
    }

    function parseDate(dateStr) {
      var dateParts = dateStr.split("/");
      var day = dateParts[0];
      var month = dateParts[1];
      var year = dateParts[2];

      return { day: day, month: month, year: year };
    }

    function getDaysInMonth(month, year) {
      if (month === 2) {
        if (year % 4 === 0 && year % 100 === 0 && year % 400 !== 0) {
          return 29;
        }
        return 28;
      } else {
        return daysInMonth[month - 1];
      }
    }

    function getDayOfWeekAtDate(day, month, year) {
      year -= month < 3;
      return (year + year/4 - year/100 + year/400 + monthDayCalc[month - 1] + day) % 7;
    }

    function stringifyDate(date) {
      return date.day + "/" + date.month + "/" + date.year;
    }

    function numDaysTillNextOccurrence(currentDate, k, daysOfTheWeek) {
      var currentDayOfWeek = getDayOfWeekAtDate(currentDate.day, currentDate.month, currentDate.year);
      //TODO:
    }

    function addDaysToDate(startDate, numDaysToAdd) {
      //TODO:
    }
  });
});