package main

import "fmt"

type Vertex2 struct {
	X int
	Y int
}

type Vertex1 struct {
	Lat, Long float64
}

/*var m = map[string]Vertex{
	"Bell Labs": Vertex{
		40.68433, -74.39967,
	},
	"Google": Vertex{
		37.42202, -122.08408,
	},
}*/

func adder() func(int) int {
	sum := 0
	return func(x int) int {
		sum += x
		return sum
	}
}

func fibonacci() func() int {
	a := 0
	b := 1
	return func() int {
		/*c := a + b
		a = b
		b = c*/
		a, b = b, a+b
		return a
	}
}

func main() {

	v := Vertex2{1, 2}
	fmt.Println(v)
	/*pos, neg := adder(), adder()
	for i := 0; i < 10; i++ {
		fmt.Println(
			pos(i),
			neg(-2*i),
		)
	}*/

	/*f := fibonacci()
	for i := 0; i < 10; i++ {
		fmt.Println(f())
	}*/
	/*fmt.Println(m)

	m := make(map[string]int)

	m["Answer"] = 42
	fmt.Println("The value:", m["Answer"])

	m["Answer"] = 48
	fmt.Println("The value:", m["Answer"])

	delete(m, "Answer")
	fmt.Println("The value:", m["Answer"])

	v, ok := m["Answer"]
	fmt.Println("The value:", v, "Present?", ok)*/

	/*i, j := 42, 2701

	p := &i         // point to i
	fmt.Println(*p) // read i through the pointer
	*p = 21         // set i through the pointer
	fmt.Println(i)  // see the new value of i

	p = &j         // point to j
	*p = *p / 37   // divide j through the pointer
	fmt.Println(j) // see the new value of j

	v := Vertex{1, 2}
	v.X = 4
	fmt.Println(v.X)

	q := &v
	q.X = 1e9
	fmt.Println(v)*/

	/*a := make([]int, 5)
	printSlice("a", a)
	b := make([]int, 0, 5)
	printSlice("b", b)
	c := b[:2]
	printSlice("c", c)
	d := b[4:5]
	printSlice("d", d)*/

	/*var a []int
	printSlice("a", a)

	// append works on nil slices.
	a = append(a, 0)
	printSlice("a", a)

	// we can add more than one element at a time.
	a = append(a, 2, 3, 4)
	printSlice("a", a)

	// the slice grows as needed.
	a = append(a, 1)
	printSlice("a", a)

	a = append(a, 5)
	printSlice("a", a)

	pow := make([]int, 10)
	for i := range pow {
		pow[i] = 1 << uint(i)
	}
	for i, value := range pow {
		fmt.Printf("%d: %d\n", i, value)
	}*/

}

func printSlice(s string, x []int) {
	fmt.Printf("%s len=%d cap=%d %v\n",
		s, len(x), cap(x), x)
}
