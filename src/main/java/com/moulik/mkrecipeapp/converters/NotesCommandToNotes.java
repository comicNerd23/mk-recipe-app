package com.moulik.mkrecipeapp.converters;

import com.moulik.mkrecipeapp.commands.NotesCommand;
import com.moulik.mkrecipeapp.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

    @Nullable
    @Synchronized
    @Override
    public Notes convert(NotesCommand source) {
        if(source == null) {
            return null;
        }
        Notes notes = new Notes();
        notes.setId(source.getId());
        notes.setRecipeNotes(source.getRecipeNotes());
        return notes;
    }
}
