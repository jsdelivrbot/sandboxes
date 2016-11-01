import {expect} from 'chai';

describe('sandbox tests', () => {

  it('sandbox', () => {
    var daysInMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    var monthDayCalc = [0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4];

    recurringTask("01/01/2015", 2, ["Monday", "Thursday"], 4);

    function recurringTask(firstDate, k, daysOfTheWeek, n) {
      var daysOfWeekInt = convertDowsToInts(daysOfTheWeek);
      var scheduledOccurrences = [];
      scheduledOccurrences.push(firstDate);

      for (var i = 1; i < n; i++) {
        scheduledOccurrences.push(
          getNextDate(scheduledOccurrences[scheduledOccurrences.length - 1], k, daysOfWeekInt));
      }

      console.log(scheduledOccurrences);
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
      var day = parseInt(dateParts[0]);
      var month = parseInt(dateParts[1]);
      var year = parseInt(dateParts[2]);

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

    //returns 0 for sunday, 6 for saturday
    function getDayOfWeekAtDate(day, month, year) {
      if (month < 3) {
        year -= 1;
      }
      return (year + Math.trunc(year / 4) - Math.trunc(year / 100) + Math.trunc(year / 400) + monthDayCalc[month - 1] + day) % 7;
    }

    function stringifyDate(date) {
      return date.day + "/" + date.month + "/" + date.year;
    }

    function numDaysTillNextOccurrence(currentDate, k, daysOfTheWeek) {
      if (daysOfTheWeek.length === 1) {
        return k * 7;
      }

      var currentDayOfWeek = getDayOfWeekAtDate(currentDate.day, currentDate.month, currentDate.year);

      for  (var i = 0; i < daysOfTheWeek.length; i++) {
        if (daysOfTheWeek[i] === currentDayOfWeek) {
          if (i === (daysOfTheWeek.length - 1)) {
            return 7 - daysOfTheWeek[i] + daysOfTheWeek[0] + 7 * (k - 1);
          } else {
            return daysOfTheWeek[i + 1] - daysOfTheWeek[i];
          }
        }
      }
    }

    function addDaysToDate(currentDate, numDaysToAdd) {
      var totalDaysOfNewDate = convertDayMonthYearToNumberOfDays(currentDate.day, currentDate.month, currentDate.year);
      totalDaysOfNewDate += numDaysToAdd;
      return convertNumberOfDaysToDayMonthYear(totalDaysOfNewDate);
    }

    function convertDowToInt(dowString) {
      switch(dowString) {
        case "Sunday":
          return 0;
        case "Monday":
          return 1;
        case "Tuesday":
          return 2;
        case "Wednesday":
          return 3;
        case "Thursday":
          return 4;
        case "Friday":
          return 5;
        case "Saturday":
          return 6;
        default:
          return 0;
      }
    }

    function convertDowsToInts(daysOfTheWeek) {
      var daysOfTheWeekInts = [];
      daysOfTheWeek.forEach(function(dow) {
        daysOfTheWeekInts.push(convertDowToInt(dow));
      });
      return daysOfTheWeekInts;
    }

    function convertDayMonthYearToNumberOfDays(day, month, year) {
      month = (month + 9) % 12;
      year = year - month / 10;
      return 365 * year + Math.trunc(year / 4) - Math.trunc(year / 100) + Math.trunc(year / 400) +
        Math.trunc((month * 306 + 5) / 10) + day - 1;
    }

    function convertNumberOfDaysToDayMonthYear(numDays) {
      var year = Math.trunc((10000 * numDays + 14780) / 3652425);
      var ddd = numDays - (365 * year + Math.trunc(year/4) - Math.trunc(year/100) + Math.trunc(year/400));
      if (ddd < 0) {
        year = year - 1;
        ddd = numDays - (365 * year + Math.trunc(year / 4) - Math.trunc(year / 100) + Math.trunc(year / 400));
      }
      var mi = Math.trunc((100 * ddd + 52)/3060);
      var month = (mi + 2) % 12 + 1;
      year = year + Math.trunc((mi + 2) / 12);
      var day = ddd - Math.trunc((mi * 306 + 5)/10) + 1;
      return { day: day, month: month, year: year };
    }
  });
});