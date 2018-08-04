package main

import (
	"fmt"
	"os"
)

type Reader interface {
	Read(b []byte) (n int, err error)
}

type Writer interface {
	Write(b []byte) (n int, err error)
}

type ReadWriter interface {
	Reader
	Writer
}

type Person struct {
	Name string
	Age  int
}

func (p Person) String() string {
	return fmt.Sprintf("%v (%v years)", p.Name, p.Age)
}

func main() {
	var w Writer

	// os.Stdout 实现了 Writer
	w = os.Stdout

	fmt.Fprintf(w, "hello, writer\n")

	a := Person{"Arthur Dent", 42}
	z := Person{"Zaphod Beeblebrox", 9001}

	fmt.Println(a, z)
}
