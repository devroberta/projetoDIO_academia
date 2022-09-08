package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.form.AlunoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

  @Autowired
  private AlunoServiceImpl service;

  @GetMapping
  public List<Aluno> getAll() {
    return service.getAll();
  }

  @PostMapping
  public Aluno create(@Valid @RequestBody AlunoForm form) {
    return service.create(form);
  }

  @GetMapping("/avaliacoes/{id}")
  public List<AvaliacaoFisica> getAllAvaliacaoFisica (@PathVariable Long id) {
    return service.getAllAvaliacaoFisicaPorId(id);
  }

  @GetMapping("/dataDeNascimento")
  public List<Aluno> getAllByDataDeNascimento(
          @RequestParam(value = "dataDeNascimento", required = false) String dataDeNascimento) {
    return service.getAllByDataDeNascimento(dataDeNascimento);
  }

  @PutMapping("/update/{id}")
  public Aluno update(@PathVariable Long id, @Valid @RequestBody AlunoUpdateForm formUpdate) {
    return service.update(id, formUpdate);
  }

  @DeleteMapping("/delete/{id}")
  public void delete(@PathVariable Long id) {
    service.delete(id);
  }

  @GetMapping("/{id}")
  public Aluno getAlunoById (@PathVariable Long id) {
    return service.getAlunoById(id);
  }

}
