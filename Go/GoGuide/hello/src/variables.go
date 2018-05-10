package main

import (
	"fmt"
)

var i, j int = 1, 2

var (
	ToBe   bool   = false
	maxInt uint64 = 1<<64 - 1
)

const (
	Big   = 1 << 100
	Small = Big >> 99
)

func needInt(x int) int { return x*10 + 1 }

func needFloat(x float64) float64 {
	return x * 0.1
}

func main() {
	var c, python, java = true, false, "no!"
	fmt.Println(i, j, c, python, java)

	const f = "%T(%v)\n"
	//fmt.Printf(f, ToBe, ToBe)
	//fmt.Printf(f, maxInt, maxInt)

	//var x, y int = 3, 4
	//var ff float64 = math.Sqrt(float64(x*x + y*y))
	//var z int = int(ff)
	//fmt.Println(x, y, z)

	fmt.Printf(f, Small, Small)
	//fmt.Printf(f, Big, Big)

	fmt.Println(needInt(Small))
	fmt.Println(needFloat(Small))
	fmt.Println(needFloat(Big))
	//fmt.Println(needInt(Big))
}
