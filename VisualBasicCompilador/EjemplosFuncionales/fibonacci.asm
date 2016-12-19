.data
_num1: .word 0
_num2: .word 1
_num3: .word 0
_fibonacci: .word 0
_i: .word 0
_msg1: .asciiz "Ingrese cuantos valores de fibonacci quiere visualizar "
_msg2: .asciiz " "

.text
.globl main

main:
	li $v0, 4
	la $a0,_msg1
	syscall

	li $v0, 5
	syscall
	sw $v0,_fibonacci

	li $v0, 1
	lw $a0,_num1
	syscall

	li $v0, 1
	lw $a0,_num2
	syscall

_etiqueta0:

	lw $t0, _i
	lw $t1, _fibonacci
	blt $t0, $t1, _etiqueta1
	b _etiqueta2

_etiqueta1:

	lw $t0, _num1
	lw $t1,_num2
	add $t2, $t0, $t1
	sw $t2,_num3
	li $v0, 1
	lw $a0,_num3
	syscall

	lw $t0,_num2
	sw $t0,_num1
	lw $t0,_num3
	sw $t0,_num2
	li $v0, 4
	la $a0,_msg2
	syscall

	lw $t0, _i
	li $t1, 1
	add $t2, $t0, $t1
	sw $t2,_i
	b _etiqueta0

_etiqueta2:


	li $v0,10
	syscall
