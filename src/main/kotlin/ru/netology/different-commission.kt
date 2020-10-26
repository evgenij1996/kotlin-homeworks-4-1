package ru.netology

import java.util.*

fun main() {
    while (true) {
        println("Введите сумму текущего и предыдущего перевода в копейках")
        println("""Введите тип карты/счёта:
            1. MasterCard
            2. Maestro
            3. Viza
            4. Мир
            5. Vk Pay
        """.trimMargin())
        val scanner = Scanner(System.`in`)
        val currentTransfersSum = scanner.next().toInt()
        val previousTransfersSumMonth = scanner.next().toInt()
        val cardAccountType = scanner.next().toInt()
        val taxvizaMir = 0.75
        val minTaxVizaMir = 35 * 100
        val limitMonthMastercardMaestro = 75_000 * 100
        val taxMonthMastercardMaestro = 0.6
        val additionaltaxMonthMastercardMaestro = 20 * 100
        val maximumMonthlyTransferCard = 600_000 * 100
        val maximumTransferDayCard = 150_000 * 100
        val maximumMonthlyTransferVkPay = 40_000 * 100
        val maximumTransferDayVkPay = 15_000 * 100

        if (!spotCardAccountType(cardAccountType,
                        currentTransfersSum,
                        previousTransfersSumMonth,
                        maximumTransferDayCard,
                        maximumMonthlyTransferCard,
                        maximumMonthlyTransferVkPay,
                        maximumTransferDayVkPay)) continue

        val transfersComission = spotTaxOnCardAccount(cardAccountType,
                currentTransfersSum,
                previousTransfersSumMonth,
                taxvizaMir,
                minTaxVizaMir,
                limitMonthMastercardMaestro,
                taxMonthMastercardMaestro,
                additionaltaxMonthMastercardMaestro)

        val finalTransfersSum = calculationFinalTransfersSum(currentTransfersSum, transfersComission)

        println("Сумма комиссии $transfersComission коп")
        println("Сумма перевода с учётом комиссии $finalTransfersSum коп")
    }
}

fun spotCardAccountType(cardAccountType: Int,
                        currentTransfersSum: Int,
                        previousTransfersSumMonth: Int,
                        maximumTransferDayCard: Int,
                        maximumMonthlyTransferCard: Int,
                        maximumMonthlyTransferVkPay: Int,
                        maximumTransferDayVkPay: Int): Boolean =
        when {
            (cardAccountType in 1..4) -> {
                chekLimitMaxTransferCard(currentTransfersSum,
                        previousTransfersSumMonth,
                        maximumTransferDayCard,
                        maximumMonthlyTransferCard)
            }
            (cardAccountType == 5) -> {
                chekLimitMaxTransferAccount(currentTransfersSum,
                        previousTransfersSumMonth,
                        maximumMonthlyTransferVkPay,
                        maximumTransferDayVkPay)
            }
            else -> false
        }

fun chekLimitMaxTransferCard(currentTransfersSum: Int,
                             previousTransfersSumMonth: Int,
                             maximumTransferDayCard: Int,
                             maximumMonthlyTransferCard: Int): Boolean {
    if (currentTransfersSum > maximumTransferDayCard) {
        println("Сумма перевода превышает дневной лимит: $maximumTransferDayCard коп")
        return false
    }
    if (previousTransfersSumMonth > maximumMonthlyTransferCard) {
        println("Сумма перевода превышает месячный лимит: $maximumMonthlyTransferCard коп")
       return false
    } else return true
}

fun chekLimitMaxTransferAccount(currentTransfersSum: Int,
                                previousTransfersSumMonth: Int,
                                maximumMonthlyTransferVkPay: Int,
                                maximumTransferDayVkPay: Int): Boolean {
    if (currentTransfersSum > maximumTransferDayVkPay) {
        println("Сумма перевода превышает дневной лимит: $maximumTransferDayVkPay коп")
        return false
    }

    if (previousTransfersSumMonth > maximumMonthlyTransferVkPay) {
        println("Сумма перевода превышает дневной лимит: $maximumMonthlyTransferVkPay коп")
        return false
    } else return true
}

fun spotTaxOnCardAccount(cardAccountType: Int,
                         currentTransfersSum: Int,
                         previousTransfersSumMonth: Int,
                         taxvizaMir: Double,
                         minTaxVizaMir: Int,
                         limitMonthMastercardMaestro: Int,
                         taxMonthMastercardMaestro: Double,
                         additionaltaxMonthMastercardMaestro: Int): Int =
        when (cardAccountType) {
            1, 2 -> if (previousTransfersSumMonth + currentTransfersSum < limitMonthMastercardMaestro)
                0 else ((currentTransfersSum * taxMonthMastercardMaestro)
                    / 100 + additionaltaxMonthMastercardMaestro).toInt()
            3, 4 -> if (currentTransfersSum > minTaxVizaMir)
                (currentTransfersSum * taxvizaMir).toInt() / 100 else minTaxVizaMir
            5 -> 0
            else -> throw RuntimeException()
        }

fun calculationFinalTransfersSum(currentTransfersSum: Int,
                                 transfersComission: Int): Int =
        currentTransfersSum - transfersComission