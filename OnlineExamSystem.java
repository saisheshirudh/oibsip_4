import java.util.*;

class Question {
    private String questionText;
    private List<String> options;
    private int correctOption;

    public Question(String questionText, List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public boolean isCorrect(int selectedOption) {
        return selectedOption == correctOption;
    }

    public List<String> getOptions() {
        return options;
    }

    @Override
    public String toString() {
        StringBuilder questionString = new StringBuilder(questionText + "\n");
        for (int i = 0; i < options.size(); i++) {
            questionString.append(i + 1).append(". ").append(options.get(i)).append("\n");
        }
        return questionString.toString();
    }
}

class Exam {
    private List<Question> questions;
    private int totalMarks;

    public Exam(List<Question> questions) {
        this.questions = questions;
        this.totalMarks = questions.size();
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public int gradeExam(List<Integer> selectedOptions) {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).isCorrect(selectedOptions.get(i))) {
                score++;
            }
        }
        return score;
    }
}

public class OnlineExamSystem {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        // ... (create questions and add to the list)
        questions.add(new Question("What is 2 + 2?", Arrays.asList("3", "4", "5"), 2));
        questions.add(new Question("Which planet is known as the Red Planet?", Arrays.asList("Mars", "Venus", "Jupiter"), 1));
        

        Exam exam = new Exam(questions);

        Scanner scanner = new Scanner(System.in);
        List<Integer> selectedOptions = new ArrayList<>();

        System.out.println("Welcome to the Online Exam!");
        System.out.println("There are " + exam.getTotalMarks() + " questions in the exam.\n");

        for (int i = 0; i < exam.getTotalMarks(); i++) {
            System.out.println("Question " + (i + 1) + ":");
            System.out.println(exam.getQuestions().get(i));
            System.out.print("Enter your answer (1-" + exam.getQuestions().get(i).getOptions().size() + "): ");
            int selectedOption = scanner.nextInt();
            selectedOptions.add(selectedOption);
        }

        int score = exam.gradeExam(selectedOptions);
        System.out.println("Your score: " + score + "/" + exam.getTotalMarks());

        scanner.close();
    }
}
