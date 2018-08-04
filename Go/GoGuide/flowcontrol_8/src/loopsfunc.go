package main

import (
	"fmt"
	"math"
)

func Sqrt(x float64) float64 {
	y := math.Sqrt(x)
	fmt.Printf("sqrt=%v \n", y)

	z := 1.0
	for i := 0; i < 10; i++ {
		z = z - (z*z-x)/2*z
		fmt.Printf("z%v=%v \n", i, z)
		if math.Abs(y-z) < 0.1 {
			break
		}
	}
	return z
}

func main() {
	//fmt.Println(Sqrt(4))

	/*fmt.Println("counting")

	for i := 0; i < 10; i++ {
		defer fmt.Println(i)
	}

	fmt.Println("done")*/
}
