package it.ioprogrammatore.task.utils;

import it.ioprogrammatore.task.models.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskUtils {

    public static String randomDescription(int length) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'

        Random random = new Random();
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    public static List<Task> generateTasksList(int num) {
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            if (i % 2 == 0) {
                tasks.add(generateRandomTaskFuture());
            } else {
                tasks.add(generateRandomTaskPast());
            }
        }
        return tasks;
    }

    public static Task generateRandomTaskFuture() {
        return new Task().description(TaskUtils.randomDescription(7)).dueDate(LocalDate.now().plusDays((int) (Math.random() * 10))).priority((int) (Math.random() * 5));
    }

    public static Task generateRandomTaskPast() {
        return new Task().description(TaskUtils.randomDescription(7)).dueDate(LocalDate.now().minusDays((int) (Math.random() * 10))).priority((int) (Math.random() * 5));
    }
}
