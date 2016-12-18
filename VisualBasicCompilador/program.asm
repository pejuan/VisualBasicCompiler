.data
_a: .word 10
_b: .word 20
_msg1: .asciiz "Hola"

.text
.globl main

main:
	lw $t0, _b
	li $t1, 3
	add $t2, $t0, $t1
	sw $t2,_b
_etiqueta0:

	li $v0, 4
	la $a0,_msg1
	syscall

	lw $t0, _a
	li $t1, 1
	add $t2, $t0, $t1
	sw $t2,_a
	lw $t0, _b
	lw $t1, _a
	bgt $t0, $t1, _etiqueta0

	li $v0,10
	syscall
