package com.example.movieapp.ui.components.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieapp.ui.components.dialog.components.button.DialogButtonsColumn
import com.example.movieapp.ui.components.dialog.components.content.DialogContentWrapper
import com.example.movieapp.ui.components.dialog.components.title.DialogTitleWrapper
import com.example.movieapp.ui.models.dialog.DialogButton
import com.example.movieapp.ui.models.dialog.DialogContent
import com.example.movieapp.ui.models.dialog.DialogText
import com.example.movieapp.ui.models.dialog.DialogTitle
import com.example.movieapp.ui.theme.MovieAppTheme
import com.example.movieapp.ui.theme.Paddings
import com.example.movieapp.ui.theme.colorScheme

@Composable
fun BaseDialogPopup(
    dialogTitle : DialogTitle? = null,
    dialogContent : DialogContent? = null,
    button : List<DialogButton>? = null
) {
    Card (
      modifier = Modifier.fillMaxWidth(),
        elevation = Paddings.none,
        backgroundColor = MaterialTheme.colorScheme.background,
        shape = MaterialTheme.shapes.large
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            dialogTitle?.let{
                DialogTitleWrapper(it)
            }
            Column(
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxWidth()
                    .padding(
                        start = Paddings.xlarge,
                        end = Paddings.xlarge,
                        bottom = Paddings.xlarge,
                    )
            ) {
                dialogContent?.let{
                    DialogContentWrapper(it)
                }
                button?.let {
                    DialogButtonsColumn(it)
                }
            }
        }
    }
}

@Preview
@Composable
fun BaseDialogPopupPreview() {
    MovieAppTheme {
        BaseDialogPopup(
            dialogTitle = DialogTitle.Header("Title"),
            dialogContent = DialogContent.Large(
                DialogText.Default("abcde abcde abcde abcde abcde abcde abcde abcde abcde abcde abcde abcde abcde abcde abcde ")
            ),
            button = listOf(
                DialogButton.Primary("Okay"){}
            )
        )
    }
}

@Preview
@Composable
fun BaseDialogPopupPreview2() {
    MovieAppTheme {
        BaseDialogPopup(
            dialogTitle = DialogTitle.Large("Title"),
            dialogContent = DialogContent.Default(
                DialogText.Default("abcde abcde abcde abcde abcde abcde abcde abcde abcde abcde abcde abcde abcde abcde abcde ")
            ),
            button = listOf(
                DialogButton.Secondary("Okay"){},
                DialogButton.UnderlinedText("Cancel"){}
            )
        )
    }
}

@Preview
@Composable
fun BaseDialogPopupPreview3() {
    MovieAppTheme {
        BaseDialogPopup(
            dialogTitle = DialogTitle.Large("Title"),
            dialogContent = DialogContent.Rating(
                DialogText.Rating(
                    text = "Jurassic Park",
                    rating = 8.2f
                )
            ),
            button = listOf(
                DialogButton.Primary("Okay"){},
                DialogButton.Secondary("Cancel"){}
            )
        )
    }
}