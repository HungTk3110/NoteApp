package com.example.note_application.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.note_application.databinding.ActivityAddNoteBinding
import com.example.note_application.model.Note
import com.example.note_application.viewmodel.NoteViewModel

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)


        binding.btnAdd.setOnClickListener {
            val note = Note(null, binding.edtTitle.text.toString(), binding.edtDes.text.toString())
            noteViewModel.insertNote(note)
            finish()
        }
    }
}