.data
_a: .word RET
_b: .word 0
_c: .word 0

.text
.globl main

main:
	li $t0, 10
	li $t1, 2
	mul $t2, $t0, $t1
	li $t0, 50
	sub $t1, $t0, $t2
	sw $t1,_c
	li $v0, 1
	lw $a0,_c
	syscall


	li $v0,10
	syscall
