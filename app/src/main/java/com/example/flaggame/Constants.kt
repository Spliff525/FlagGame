package com.example.flaggame



object Constants{

  const val USER_NAME: String = "user_name"
  const val TOTAL_QUESTIONS: String = "total_question"
  const val CORRECT_ANSWERS: String = "correct_answers"


  val q1 = Question(1, "What country does this flag belong to?", R.drawable.nl, "Nigeria", "Congo", "Qatar", "Netherlands", 4)
  val q2 = Question(2, "What country does this flag belong to?", R.drawable.om, "Bahrain", "Qatar", "Oman", "Kuwait", 3)
  val q3 = Question(3, "What country does this flag belong to?", R.drawable.ao, "Cyprus", "Angola", "Mozambique", "South Africa", 2)
  val q4 = Question(4, "What country does this flag belong to?", R.drawable.bd, "Chile", "Pakistan", "Bangladesh", "India", 3)
  val q5 = Question(5, "What country does this flag belong to?", R.drawable.bh, "France", "Bahrain", "Qatar", "Kuwait", 2)
  val q6 = Question(6, "What country does this flag belong to?", R.drawable.ci, "Ireland", "Mali", "Ivory Coast", "Niger", 3)
  val q7 = Question(7, "What country does this flag belong to?", R.drawable.ec, "Ecuador", "Colombia", "Venezuela", "Peru", 1)
  val q8 = Question(8, "What country does this flag belong to?", R.drawable.zw, "Kenya", "Zambia", "South Africa", "Zimbabwe", 4)
  val q9 = Question(9, "What country does this flag belong to?", R.drawable.uy, "Argentina", "Paraguay", "Uruguay", "Chile", 3)
  val q10 = Question(10, "What country does this flag belong to?", R.drawable.se, "Denmark", "Norway", "Finland", "Sweden", 4)
  val q11 = Question(11, "What country does this flag belong to?", R.drawable.sl, "Somalia", "Sierra Leone", "Liberia", "Gabon", 2)
  val q12 = Question(12, "What country does this flag belong to?", R.drawable.pl, "Poland", "Monaco", "Indonesia", "Austria", 1)
  val q13 = Question(13, "What country does this flag belong to?", R.drawable.tj, "Uzbekistan", "Tajikistan", "Turkmenistan", "Kyrgyzstan", 2)
  val q14 = Question(14, "What country does this flag belong to?", R.drawable.sa, "Iraq", "Pakistan", "Iran", "Saudi Arabia", 4)
  val q15 = Question(15, "What country does this flag belong to?", R.drawable.ng, "Nigeria", "Niger", "Ghana", "Cameroon", 1)
  val q16 = Question(16, "What country does this flag belong to?", R.drawable.et, "Somalia", "Eritrea", "Ethiopia", "Sudan", 3)
  val q17 = Question(17, "What country does this flag belong to?", R.drawable.cm, "Swaziland", "Cameroon", "Senegal", "Mali", 2)
  val q18 = Question(18, "What country does this flag belong to?", R.drawable.gh, "Turkey", "Cameroon", "Mali", "Ghana", 4)
  val q19 = Question(19, "What country does this flag belong to?", R.drawable.ru, "Slovakia", "Russia", "Serbia", "Croatia", 2)
  val q20 = Question(20, "What country does this flag belong to?", R.drawable.pk, "Pakistan", "Bangladesh", "Afghanistan", "Iran", 1)

  val questionsList = listOf(q1, q2, q20)


  fun generateQuestions(): List<Question> {
    val list = mutableListOf<Question>()

    repeat(20) {
      val tempQuestion = Question(19, "What country does this flag belong to?", R.drawable.ru, "Slovakia", "Russia", "Serbia", "Croatia", 2)
      list.add(tempQuestion)
    }
    return list
  }

}