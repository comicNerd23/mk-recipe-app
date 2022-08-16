package com.moulik.mkrecipeapp.converters;

import com.moulik.mkrecipeapp.commands.NotesCommand;
import com.moulik.mkrecipeapp.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

    @Nullable
    @Synchronized
    @Override
    public NotesCommand convert(Notes source) {
        if(source == null) {
            return null;
        }
        NotesCommand command = new NotesCommand();
        command.setId(source.getId());
        command.setRecipeNotes(source.getRecipeNotes());
        return command;
    }
}
