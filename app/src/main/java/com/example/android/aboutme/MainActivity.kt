/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android.aboutme.databinding.ActivityMainBinding


/**
 * Main Activity of the AboutMe app.
 * This codelab demonstrates how to add:
 *     * Data binding between MainActivity and activity_main.xml. How to remove findViewById,
 *       and how to display data in views using the data binding object.
 * This is the starter app.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.doneButton.setOnClickListener {
            showUserInfo(it)
        }

        binding.myName = myName

    }

    /**
     * Click handler for the Done button.
     */
    private fun showUserInfo(view: View) {
        binding.apply {
            myName?.name = nameEdit.text.toString()
            myName?.nickname = nicknameEdit.text.toString()
            myName?.age = ageEdit.text.toString()
            myName?.birthday = birthdayEdit.text.toString()
            myName?.number = numberEdit.text.toString()
            myName?.color = colorEdit.text.toString()
            myName?.course = courseEdit.text.toString()
            myName?.dream = dreamEdit.text.toString()
            myName?.crush = crushEdit.text.toString()
            myName?.message = messageEdit.text.toString()
            invalidateAll()

            helloText.visibility = View.GONE
            nameText.visibility = View.GONE
            nicknameText.visibility = View.GONE
            ageText.visibility = View.GONE
            birthdayText.visibility = View.GONE
            numberText.visibility = View.GONE
            colorText.visibility = View.GONE
            courseText.visibility = View.GONE
            dreamText.visibility = View.GONE
            crushText.visibility = View.GONE
            messageText.visibility = View.GONE
            nameEdit.visibility = View.GONE
            nicknameEdit.visibility = View.GONE
            ageEdit.visibility = View.GONE
            birthdayEdit.visibility = View.GONE
            numberEdit.visibility = View.GONE
            colorEdit.visibility = View.GONE
            courseEdit.visibility = View.GONE
            dreamEdit.visibility = View.GONE
            crushEdit.visibility = View.GONE
            messageEdit.visibility = View.GONE
            doneButton.visibility = View.GONE

            userName.visibility = View.VISIBLE
            userNickname.visibility = View.VISIBLE
            userAge.visibility = View.VISIBLE
            thanksText.visibility = View.VISIBLE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
