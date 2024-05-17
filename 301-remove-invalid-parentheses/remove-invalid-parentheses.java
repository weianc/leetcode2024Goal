class Solution {
    private Set<String> res = new HashSet<>();  // 使用 Set 避免重复
    private int maxLen = 0;  // 记录所找到的最大长度的有效字符串

    public List<String> removeInvalidParentheses(String s) {
        // 计算最少需要删除的左括号和右括号数量
        int leftRem = 0, rightRem = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftRem++;
            } else if (c == ')') {
                if (leftRem > 0) {
                    leftRem--;
                } else {
                    rightRem++;
                }
            }
        }

        // 开始回溯寻找所有的最长有效括号组合
        StringBuilder sb = new StringBuilder();
        backtrack(s, 0, sb, 0, leftRem, rightRem);
        return new ArrayList<>(res);
    }

    private void backtrack(String s, int index, StringBuilder sb, int balance, int leftRem, int rightRem) {
        // 基本情况，如果处理完所有的字符
        if (index == s.length()) {
            // 如果平衡计数器为0，则当前路径是一个有效的组合
            if (balance == 0) {
                // 如果当前字符串长度大于最大长度，则更新结果集
                if (sb.length() > maxLen) {
                    res.clear();
                    maxLen = sb.length();
                }
                // 如果当前字符串长度等于最大长度，添加到结果集
                if (sb.length() == maxLen) {
                    res.add(sb.toString());
                }
            }
            return;
        }

        char c = s.charAt(index);
        int len = sb.length();

        // 如果当前字符是 '('
        if (c == '(') {
            // 选择不包含这个 '('
            if (leftRem > 0) {
                backtrack(s, index + 1, sb, balance, leftRem - 1, rightRem);
            }
            // 选择包含这个 '('
            sb.append(c);
            backtrack(s, index + 1, sb, balance + 1, leftRem, rightRem);
        } else if (c == ')') {
            // 选择不包含这个 ')'
            if (rightRem > 0) {
                backtrack(s, index + 1, sb, balance, leftRem, rightRem - 1);
            }
            // 选择包含这个 ')'，只有当当前平衡大于 0 时才有效
            if (balance > 0) {
                sb.append(c);
                backtrack(s, index + 1, sb, balance - 1, leftRem, rightRem);
            }
        } else {
            // 如果当前字符不是括号，总是要包含它
            sb.append(c);
            backtrack(s, index + 1, sb, balance, leftRem, rightRem);
        }

        // 回溯，撤销选择
        sb.setLength(len);
    }
}