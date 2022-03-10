package lab2;

public abstract class Algorithm {
    Problem problem = new Problem();

    public Algorithm() {
    }

    public Algorithm(Problem problem) {
        this.problem = problem;
    }

    public Solution solve() {
        Solution sol = new Solution();
        return sol;
    }
}
