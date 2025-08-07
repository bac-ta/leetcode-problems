package algorithm_patterns.segmenttree;

class SegmentTreeDataStructure {
    private final int[] tree;           // Cây segment tree
    private final int[] originalArray;  // Mảng đầu vào
    private final int size;             // Kích thước mảng đầu vào

    public SegmentTreeDataStructure(int[] nums) {
        this.size = nums.length;
        this.originalArray = nums;
        this.tree = new int[4 * size]; // Dư sức chứa
        build(0, 0, size - 1); // rootIndex = 0, interval = [0, size-1]
    }

    // Xây dựng cây tại nodeIndex, tương ứng với đoạn [left, right]
    private void build(int nodeIndex, int left, int right) {
        if (left == right) {
            tree[nodeIndex] = originalArray[left];
            return;
        }

        int mid = left + right / 2;

        build(2 * nodeIndex, left, mid);
        build(2 * nodeIndex + 1, mid + 1, right);

        tree[nodeIndex] = tree[2 * nodeIndex] + tree[2 * nodeIndex + 1];
    }

    // Truy vấn tổng từ queryLeft đến queryRight
    public int query(int queryLeft, int queryRight) {
        return query(0, 0, size - 1, queryLeft, queryRight);
    }

    private int query(int nodeIndex, int left, int right, int queryLeft, int queryRight) {
        // Ngoài phạm vi
        if (queryRight < left || right < queryLeft)
            return 0;

        // Trùm hoàn toàn trong đoạn query
        if (queryLeft <= left && right <= queryRight)
            return tree[nodeIndex];

        int mid = (left + right) / 2;

        int leftSum = query(2 * nodeIndex, left, mid, queryLeft, queryRight);
        int rightSum = query(2 * nodeIndex, mid + 1, right, queryLeft, queryRight);

        return leftSum + rightSum;
    }

    // Cập nhật giá trị tại vị trí updateIndex
    public void update(int updateIndex, int newValue) {
        update(0, 0, size - 1, updateIndex, newValue);
    }

    private void update(int nodeIndex, int left, int right, int updateIndex, int newValue) {
        if (left == right) {
            originalArray[updateIndex] = newValue;
            tree[nodeIndex] = newValue;
            return;
        }

        int mid = (left + right) / 2;
        if (updateIndex <= mid) {
            update(2 * nodeIndex, left, mid, updateIndex, newValue);
        } else {
            update(2 * nodeIndex + 1, mid + 1, right, updateIndex, newValue);
        }

        tree[nodeIndex] = tree[2 * nodeIndex] + tree[2 * nodeIndex + 1];
    }
}
