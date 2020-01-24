// /**
//  * HeapSort Algorithm is a comparison based sorting algorith. 
//  * It is an improved selection sort because it leverages Heap Data Structure.
//  * Unlike Selection Sort which uses  linear search algrotihm.
//  * 
//  * Best: O(n)
//  * Average, Worst: O(n lgn)
//  */
// class HeapSort{

//     private void sort(int input[]) {
//         int size = input.length;

//         for (int i = size / 2 - 1; i >= 0; i--) {
//             heapify(input, size, i);
//         }
//     }

//     public static void main(String[] args) {
//         int[] numberArray = {12, 25, 11, 22, 64};
//         sort(numberArray);
//     }
// }