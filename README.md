# Figure Editor Swing (Maven + Java 21)

Aplicação simples em **Java Swing**: **clique** para inserir uma figura na tela.
- **Clique**: insere figura do tamanho padrão.

## Rodar
```bash
mvn -q exec:java
```
> Requer Maven e JDK 21+

## Estrutura
```
src/main/java/br/com/mariojp/figureeditor/
  App.java            # main + janela
  DrawingPanel.java   # painel de desenho

```

## Ideias de evolução
- Clique + Arraste: define o tamanho (pré-visualização tracejada).
- Botão "Cor..."** escolhe a cor.
- Seleção/movimentação de figuras
- Camadas e alinhamento magnético
- Exportar PNG/SVG
- Undo/Redo (Memento + Command)
