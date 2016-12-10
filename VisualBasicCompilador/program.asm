.data
_a: .word 10
_b: .word 20
_c: .word 30

.text
.globl main

main:
	lw $t0, _b
	li $t1, 2
	mul $t2, $t0, $t1
	sw $t2,_a

	li $t0, 10
	lw $t1,_b

	mul $t2, $t0, $t1
	li $t0, 50

	sub $t1, $t0, $t2
	sw $t1,_c
	
	li $v0, 1
	lw $a0,_a
	syscall

	li $v0, 1
	lw $a0,_b
	syscall

	li $v0, 1
	lw $a0,_c
	syscall


	li $v0,10
	syscall
